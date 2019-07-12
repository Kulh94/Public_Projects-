package Controller;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Repository
public class Manager {
    @Autowired(required = true)
    private AdvertisementRepository advertisementRepository;

    @Autowired(required=true)
    private UserRepository userRepository;

    private static final String urlM1 = "http://10.101.111.13:8094/ms1/";
    private static final String urlM3 = "http://10.101.111.9:8080/";
    private static final String TOKEN_SECRET = "DSE";

    /**
     * Add new advertisement
     *
     * @param advertisement
     * @param userId
     * @return ResponseEntity
     */
    public ResponseEntity addNewAdvertisement(Advertisement advertisement, Long userId) {
        try {
            if(advertisement.getId() == null && userId != null && validateUser(userId)) {
                Date date = new Date();
                java.sql.Date today = new java.sql.Date(date.getTime());
                advertisement.setPublishDate(today);
                if (userRepository.existsById(userId)){
                    advertisement.setUser(userRepository.findById(userId).get());
                } else {
                    User user = new User();
                    user.setId(userId);
                    userRepository.save(user);
                    advertisement.setUser(user);
                }
                advertisementRepository.save(advertisement);
                String result = sendAd(advertisement);
                //System.out.println("ms3: " + result);
                return new ResponseEntity(HttpStatus.OK);
            }else{
                return new ResponseEntity(HttpStatus.CONFLICT);
            }
        }catch(IllegalArgumentException e){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }

    /**
     * Delete Advertisement by ID
     *
     * @param id
     * @return ResponseEntity
     */
    public ResponseEntity deleteAdvertisement(Long id) {
        if (advertisementRepository.findById(id) != null) {
            advertisementRepository.deleteById(id);
            sendId(id);
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


    /**
     * Get all Advertisements
     *
     * @return ResponseEntity
     */
    public ResponseEntity<Iterable<Advertisement>> getAllAds() {
        if(advertisementRepository.findAll() != null) {
            return new ResponseEntity<>(advertisementRepository.findAll(), HttpStatus.OK);
        }
        return new ResponseEntity<Iterable<Advertisement>>(HttpStatus.NO_CONTENT);
    }

    /**
     * Get Advertisment by ID
     * @param id
     * @return Advertisement
     */
    public Advertisement getAdById(Long id) {
        if (advertisementRepository.findById(id) != null) {
            return advertisementRepository.findById(id).get();
        }
        return null;
    }


    /**
     * Get Advertisements of one user by userID
     *
     * @param userId
     * @return ResponseEntity
     */
    public ResponseEntity<List<Advertisement>> getUserAds(Long userId) {
        if (userRepository.existsById(userId) && validateUser(userId)) {
            List<Advertisement> userAds = new ArrayList<>();
            Iterable<Advertisement> allAds = advertisementRepository.findAll();
            for (Advertisement advertisement : allAds) {
                if (userId.equals(advertisement.getUser().getId())) {
                    userAds.add(advertisement);
                }
            }
            return new ResponseEntity<>(userAds, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Update the advertisement
     *
     * @param advertisement
     * @param userId
     * @return ResponseEntity
     */
    public ResponseEntity updateAdvertisement(Advertisement advertisement, Long userId) {
        if (userRepository.findById(userId).get() != null && validateUser(userId)) {
            return advertisementRepository.findById(advertisement.getId())
                    .map(ad -> {
                        ad.setPrice(advertisement.getPrice());
                        ad.setEmail(advertisement.getEmail());
                        ad.setDescription(advertisement.getDescription());
                        ad.setTitle(advertisement.getTitle());
                        advertisementRepository.save(ad);
                        sendAd(ad);
                        return new ResponseEntity(HttpStatus.OK);
                    })
                    .orElseGet(() -> {
                        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                    });
        }
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


    /**
     * Request to MS1 to validate user
     *
     * @param token
     * @param id
     * @return HttpStatus
     */

    private static HttpStatus validateToken(String token, Long id) {
        final String url = "10.101.111.17:8080/app/validate/";
        MultiValueMap<String, Long> params = new LinkedMultiValueMap<String, Long>();
        params.add("id", id);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        HttpEntity<MultiValueMap<String, Long>> request = new HttpEntity<MultiValueMap<String, Long>>(params, headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<HttpStatus> result = restTemplate.postForEntity(url, request, HttpStatus.class);

        return result.getStatusCode();
    }


    /**
     * Parse token and take id information
     *
     * @param token
     * @return Long
     */
    private static Long parseToken(String token) {
        String id = null;
        try {
            System.out.println("TOKEN: " + token);
            id = Jwts.parser()
                    .setSigningKey(TOKEN_SECRET)
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
            return Long.parseLong(id);
        } catch (JwtException | ClassCastException e) {
            throw new IllegalArgumentException("Invalid Token");
        }
    }


    /**
     * Send new Advertisement to MS3
     *
     * @param ad
     * @return String
     */
    private static String sendAd(Advertisement ad) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<HttpStatus> result = restTemplate.postForEntity(urlM3 + "add/advertisement", ad, HttpStatus.class);
            return result.getStatusCode().toString();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }
    }


    /**
     * Send to MS3 the id of deleted advertisement
     *
     * @param id
     *
     */
    private static void sendId(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(urlM3 + "delete/advertisement/" + id, Boolean.class);
    }

    /**
     * Send request to MS1 to validate userId received from ms4
     * @param id
     * @return boolean
     */
    private static boolean validateUser(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        HttpStatus response = restTemplate.getForObject(urlM1 + "/valid/" + id, HttpStatus.class);
        if(response.value() == 200) {
            return true;
        }
        return false;
    }

}

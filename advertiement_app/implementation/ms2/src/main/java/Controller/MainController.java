package Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.*;


//Quelle: https://spring.io/guides/tutorials/rest/

@Controller
@RequestMapping(path="/app")
public class MainController {

	@Autowired(required = true)
	Manager manager = new Manager();


	/**
	 * Add new advertisement
	 * @param advertisement
	 * @return
	 */
	@RequestMapping(value="/add/advertisement/{userId}", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseEntity addAdvertisement(@RequestBody Advertisement advertisement, @PathVariable Long userId){ //@RequestHeader(value = "Authorization") String token) {
		ResponseEntity responseEntity = manager.addNewAdvertisement(advertisement, userId);
		return responseEntity;
	}


	/**
	 * Delete advertisement by Id
	 * @param id
	 */
	@DeleteMapping("/delete/advertisement/{id}")
	public @ResponseBody ResponseEntity deleteAd(@PathVariable Long id) {
		return manager.deleteAdvertisement(id);
	}


	/**
	 * Get all advertisements
	 * @return
	 */

	@GetMapping(path="/advertisements")
	public @ResponseBody ResponseEntity<Iterable<Advertisement>> getAllAds() {
		return manager.getAllAds();
	}


	/**
	 * Get an Advertisement by id
	 * @param id
	 * @return
	 */
	@GetMapping(path="/getAd/{id}")
	public @ResponseBody Advertisement getAd(@PathVariable Long id) {
		return manager.getAdById(id);
	}

	/**
	 * Get all ads of a user
	 * @param userId
	 * @return ResponseEntity
	 */
	@GetMapping(path="/userad/{userId}")
	public @ResponseBody ResponseEntity<List<Advertisement>> getUserAd(@PathVariable Long userId) {
		return manager.getUserAds(userId);
	}

	/**
	 * Update existing advertisement
	 * @param newAd
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/update/{userId}", method = RequestMethod.PUT, consumes = "application/json")
	public @ResponseBody ResponseEntity updateAd(@RequestBody Advertisement newAd, @PathVariable Long userId) {
		return manager.updateAdvertisement(newAd, userId);
	}

}
//Quelle: https://spring.io/guides/tutorials/rest/

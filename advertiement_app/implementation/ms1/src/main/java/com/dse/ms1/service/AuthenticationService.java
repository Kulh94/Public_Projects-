package com.dse.ms1.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.dse.ms1.config.User;
import com.dse.ms1.config.UserRepository;


/**
 * @author hakan
 * Authentication Service where registration and login are implemented and defined
 * 
 */

@Service
public class AuthenticationService implements IAuthenticationService{

		@Autowired
		private UserRepository userRepository;

		/**
		 * mapping the user object which is provided by the controller and send by ms4 
		 * @param user
		 * @return
		 */
		
		@Override
		public User registerUser(User user) {
			User u = new User();
			u.setEmail(user.getEmail());
			u.setFirstName(user.getFirstName());
			u.setLastName(user.getLastName());
			u.setPassword(user.getPassword());
			userRepository.save(u);       
			sendUser(u);
			return u;
		}

		/**
		 * logging in the user by checking if the deployed email and password equals the ones in the database
		 * @param user
		 * @return
		 */
		
		@Override
		public Long loignUser(User user) {
			List<User> users = new ArrayList<>();
			userRepository.findAll()
			.forEach(users::add);
			for(User u: users) {
				if(u.getEmail().equals(user.getEmail()) && u.getPassword().equals(user.getPassword())) {
					System.out.print("id" + u.getId());
					return u.getId();
				}
			} 
			System.out.print("not found");
			return null;
		}

		/**
		 * Checking if delivered id exists in the database
		 * @param userId
		 * @return
		 */
		
		@Override
		public boolean validateUser(Long userId) {
			return userRepository.existsById(userId);
		}

		/**
		 * provide other microservises with object user
		 * @param user
		 * @return
		 */
		
		private static String sendUser(User user) {
	        try {
	            RestTemplate restTemplate = new RestTemplate();
	            ResponseEntity<HttpStatus> result = restTemplate.postForEntity("http://10.101.111.9:8080/" + "add/user", user, HttpStatus.class);
	            return result.getStatusCode().toString();
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	            return e.getMessage();
	        }
	    }


	}

	


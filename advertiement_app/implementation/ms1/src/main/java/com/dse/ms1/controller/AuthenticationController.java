package com.dse.ms1.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import com.dse.ms1.config.User;
import com.dse.ms1.service.IAuthenticationService;
import org.springframework.web.bind.annotation.*;


/**
 * @author hakan
 * Authentication Controller which provides registration and authentication for User 
 * REST API Implementation
 * Checking if User is valid or not
 */

@Controller
@RestController
@RequestMapping(path="/ms1")
public class AuthenticationController {
	@Autowired
	private IAuthenticationService authenticationService;

	/**
	 * Registration of User mapping user into db via registerUser method and respond with object user and HttpStatus OK
	 * @param user
	 * @return
	 */
	
	 @PostMapping("register")
	public ResponseEntity<User> registerUser(@RequestBody User user) {
       User r = authenticationService.registerUser(user);
        if (r == null) {
        	  return new ResponseEntity<> (null, HttpStatus.CONFLICT);
        }
        return new ResponseEntity<User>(r, HttpStatus.OK);
        
	}
	 
	/**
	 * Login implementation via loginUser method which checks equality of email and password of the delivered user with the one in the database
	 * @param user
	 * @return
	 */
	 
	@PostMapping("login")
	public ResponseEntity<Long> loginUser(@RequestBody User user) {
		Long l = authenticationService.loignUser(user);
		if (l == null) {
			System.out.println("Login Failed");
			return new ResponseEntity<Long>(l, HttpStatus.CONFLICT);
		}
		System.out.println("Login Succesful");
		return new ResponseEntity<Long>(l, HttpStatus.OK);
	}
	
	/**
	 * Checking if User is valid by getting the id and checking if it exists in the database
	 * @param id
	 * @return
	 */
	
	@RequestMapping(value="valid/{id}", method = RequestMethod.GET)
	public @ResponseBody HttpStatus validate(@PathVariable("id") Long id) {
		if(authenticationService.validateUser(id)) {
			return HttpStatus.OK;
		}
		else {
		return HttpStatus.CONFLICT;
		}
	}

	

	
}

package com.dse.ms1.service;

import com.dse.ms1.config.User;
/**
 * Interface for Authentication Service
 * @author hakan
 *
 */

public interface IAuthenticationService {
	
	boolean validateUser(Long userId);
    User registerUser(User register);
    Long loignUser(User login);
	
}

package com.dse.ms1.config;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dse.ms1.config.User;


/**
 * @author hakan
 * defining Repository for User with the Crud extension to use its methods like save, find, exist..
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	

	
}

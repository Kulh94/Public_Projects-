package com.dse.ms1.config;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



/**
 * @author hakan
 * defining class User
 */
@Entity
@Table(name = "USER")
public class User {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		private String firstName;
		private String lastName;
		private String email;
		private String password;
		
		/**
		 * Constructors
		 */
		
		public User() {
			
		}

		public User(long id, String firstname, String lastname, String email, String password) {
			
			this.id = id;
			this.firstName = firstname;
			this.lastName = lastname;
			this.email = email;
			this.password = password;
		}

		public User(String firstname, String lastname, String email, String password) {
			
			this.firstName = firstname;
			this.lastName = lastname;
			this.email = email;
			this.password = password;
		}

		/**
		 * getter and setter methods
		 * @return
		 */
		
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstname) {
			this.firstName = firstname;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastname) {
			this.lastName = lastname;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
		
	
}

package com.spring.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.security.model.User;
import com.spring.security.repository.UserRepository;

@RestController
public class UserController {
	@Autowired
	UserRepository userRepository;
	
	@GetMapping(path="/user/{id}")
	public  User getUser(@PathVariable("id") Long id) {
		return userRepository.findById(id).get();
	}
	
	@PostMapping(path="/user",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public User saveUser(User user) {
		userRepository.save(user);
		return user;
	}
	
	@DeleteMapping(path="/user")
	public String delUser() {
		return "Deleted.";
	}
	
	@GetMapping("/logOut")
	public String logOut() {
		SecurityContextHolder.clearContext();
		
		return "Logout Succesful.";
	}
	
}

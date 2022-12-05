package com.example.chatbox.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.chatbox.dto.UserDto;
import com.example.chatbox.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userServie;
	
	/*
	 * this method used to login users
	 */
	@PostMapping("user/login")
	public ResponseEntity<?> login(@RequestBody UserDto user) {
		try {
			user = userServie.login(user);
			return new ResponseEntity<>(user,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}	
	}
	
	/*
	 * this method used to login users
	 */
	@PostMapping("user/registrion")
	public ResponseEntity<?> registraion(@RequestBody UserDto user) {
		try {
			user = userServie.Registrion(user);
			return new ResponseEntity<>(user,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}	
	}
	@PostMapping("user/check")
	public ResponseEntity<?> check(@RequestBody UserDto user) {
		try {
			user = userServie.check(user.getMailId());
			return new ResponseEntity<>(user,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}	
	}
	
}

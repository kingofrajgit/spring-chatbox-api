package com.example.chatbox.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.chatbox.Model.User;
import com.example.chatbox.converter.UserConverter;
import com.example.chatbox.dto.UserDto;
import com.example.chatbox.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository repository;

	public UserDto login(UserDto user) throws Exception {
		UserConverter converter = new UserConverter();
		User model =	converter.toModel(user);
		try {
		model = repository.save(model);
		user = converter.toDtol(model);
		return user;
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public String getText() {
		return getRandomNumber();
	}

	private String getRandomNumber() {
			Random random = new Random();
		return String.valueOf(random.nextInt(10000));
	}

	public UserDto Registrion(UserDto user) throws Exception {
		UserConverter converter = new UserConverter();
		User model =	converter.toModel(user);
		try {
		model = repository.save(model);
		user = converter.toDtol(model);
		return user;
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public UserDto check(String mailId) throws Exception {
		UserConverter converter = new UserConverter();
		UserDto dto = new UserDto();
		try {
		User model = repository.getByMailId(mailId);
		if(model != null) {
			dto = converter.toDtol(model);
		}else {
			dto = null;
		}
		return dto;
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}

}

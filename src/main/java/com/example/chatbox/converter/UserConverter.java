package com.example.chatbox.converter;

import com.example.chatbox.Model.User;
import com.example.chatbox.dto.UserDto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserConverter {
	
	/*
	 * this method used to convert dto class to model class
	 */
	public User toModel(UserDto dto) {
		User model = new User();
		model.setId(dto.getId());
		model.setName(dto.getName());
		model.setMailId(dto.getMailId());
		model.setPhoneNumber(dto.getPhoneNumber());
		model.setPath(dto.getPath());
		return model;
	}
	
	public UserDto toDtol(User model) {
		UserDto dto = new UserDto();
		dto.setId(model.getId());
		dto.setName(model.getName());
		dto.setMailId(model.getMailId());
		dto.setPhoneNumber(model.getPhoneNumber());
		dto.setPath(model.getPath());
		return dto;
	}

}

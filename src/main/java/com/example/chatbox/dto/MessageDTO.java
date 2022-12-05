package com.example.chatbox.dto;

import lombok.Data;

@Data
public class MessageDTO {

	private String message;
	
	public MessageDTO(String message) {
		super();
		this.message = message;
	}
}
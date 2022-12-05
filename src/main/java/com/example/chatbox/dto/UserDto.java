package com.example.chatbox.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor 
public class UserDto {
	
	private int id ;

	private String mailId ;
	
	private String phoneNumber ;
	
	private String name ;
	
	private String path;
	
	
	

}

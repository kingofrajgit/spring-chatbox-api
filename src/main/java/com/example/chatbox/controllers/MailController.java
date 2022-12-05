package com.example.chatbox.controllers;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.chatbox.Model.MailInformations;
import com.example.chatbox.dto.MessageDTO;
import com.example.chatbox.service.MailSenderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@RestController
public class MailController {
	
	@Autowired
	MailSenderService service;
	
	/**
	 * this method used for send a mail without attachment
	 * @param details
	 * @return
	 */
	@PostMapping("mailSender")
	public  ResponseEntity<?> mailSender(@RequestBody MailInformations details){
		String to = details.getTo();
		String subject = details.getSubject();
		try {
			String pin = String.valueOf(service.sendMail(to,subject));
			MessageDTO message = new MessageDTO(pin);
			return new ResponseEntity<>(message,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);

		}
		
	}

}

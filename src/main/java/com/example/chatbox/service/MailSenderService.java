package com.example.chatbox.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailSenderService {

	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	public UserService userService;

	public String sendMail( String to, String subject) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("spring.email.from@gmail.com");
		message.setTo(to);
		message.setSubject(subject);
		String pin = userService.getText();
		message.setText("Hello User, Don't share this pin: "+pin);
		mailSender.send(message);
		return pin;
	}

}

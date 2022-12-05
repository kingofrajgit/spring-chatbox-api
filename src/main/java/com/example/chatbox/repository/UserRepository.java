package com.example.chatbox.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.chatbox.Model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User getByMailId(String mailId);
	

}

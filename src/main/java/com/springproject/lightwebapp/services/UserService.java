package com.springproject.lightwebapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springproject.lightwebapp.models.User;
import com.springproject.lightwebapp.repositories.UserRepository;
import com.sun.xml.bind.v2.runtime.output.Encoded;

@Service
public class UserService {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	//Get All Users
	public List<User> findAll(){
		return userRepository.findAll();
	}	
	
	//Get User By Id
	public Optional<User> findById(int id) {
		return userRepository.findById(id);
	}	
	
	//Delete User
	public void delete(int id) {
		userRepository.deleteById(id);
	}
	
	//Update User
	public void save(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
	}

}

package com.springproject.lightwebapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springproject.lightwebapp.models.MyPrincipalUser;
import com.springproject.lightwebapp.models.User;
import com.springproject.lightwebapp.repositories.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	private UserRepository userRepository;
	
	@Autowired
	public MyUserDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException("User " + username + " not found.");
		}
		
		return new MyPrincipalUser(user);
	}

}

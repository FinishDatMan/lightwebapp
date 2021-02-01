package com.springproject.lightwebapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproject.lightwebapp.models.Client;
import com.springproject.lightwebapp.repositories.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private final ClientRepository clientRepository;
	
	public ClientService(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}
	
	public List<Client> findAll(){
		return clientRepository.findAll();
	}	
	
	//Get Client By Id
	public Optional<Client> findById(int id) {
		return clientRepository.findById(id);
	}	
	
	//Delete Client
	public void delete(int id) {
		clientRepository.deleteById(id);
	}
	
	//Update Client
	public void save( Client client) {
		clientRepository.save(client);
	}

}

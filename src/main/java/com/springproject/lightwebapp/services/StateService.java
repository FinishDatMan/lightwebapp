package com.springproject.lightwebapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproject.lightwebapp.models.State;
import com.springproject.lightwebapp.repositories.StateRepository;

@Service
public class StateService {
	
	private StateRepository stateRepository;

	@Autowired
	public StateService(StateRepository stateRepository) {
		this.stateRepository = stateRepository;
	}

	public List<State> getStates() {
		return stateRepository.findAll();
	}
	public void save(State state) {
		stateRepository.save(state);
	}

	public Optional<State> findById(Integer id) {
		return stateRepository.findById(id);
	}

	public void delete(Integer id) {
		stateRepository.deleteById(id);
	}
	
	
	

}

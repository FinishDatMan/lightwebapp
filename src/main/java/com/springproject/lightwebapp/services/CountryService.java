package com.springproject.lightwebapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproject.lightwebapp.models.Country;
import com.springproject.lightwebapp.repositories.CountryRepository;

@Service
public class CountryService {
	
	private CountryRepository countryRepository;
	
	@Autowired
	public CountryService(CountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}
	
	public List<Country> getCountries() {
		return countryRepository.findAll();
	}
	
	public void save(Country country) {
		countryRepository.save(country);
	}
	
	public void delete(Integer id) {
		countryRepository.deleteById(id);
	}
	
	public Optional<Country> findById(Integer id) {
		return countryRepository.findById(id);
	}

}

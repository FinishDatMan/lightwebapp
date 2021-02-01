package com.springproject.lightwebapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproject.lightwebapp.models.EmployeeType;
import com.springproject.lightwebapp.repositories.EmployeeTypeRepository;

@Service
public class EmployeeTypeService {
	
	private EmployeeTypeRepository employeeTypeRepository;
	
	@Autowired
	public EmployeeTypeService(EmployeeTypeRepository employeeTypeRepository) {
		this.employeeTypeRepository = employeeTypeRepository;
	}

	public List<EmployeeType> findAll() {
		return employeeTypeRepository.findAll();
	}

	

}

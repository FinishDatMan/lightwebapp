package com.springproject.lightwebapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproject.lightwebapp.models.Employee;
import com.springproject.lightwebapp.repositories.EmployeeRepository;

@Service
public class EmployeeService {
		
	
	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	public List<Employee> findAll(){
		return employeeRepository.findAll();
	}	
	
	public Optional<Employee> findById(int id) {
		return employeeRepository.findById(id);
	}	
	
	public void delete(int id) {
		employeeRepository.deleteById(id);
	}
	
	public void save( Employee employee) {
		employeeRepository.save(employee);
	}
	
	public Employee findByUsername(String un) {
		return employeeRepository.findByUsername(un);
	}
}

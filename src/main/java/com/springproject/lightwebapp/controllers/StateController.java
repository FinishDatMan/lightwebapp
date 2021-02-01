package com.springproject.lightwebapp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springproject.lightwebapp.models.Country;
import com.springproject.lightwebapp.models.State;
import com.springproject.lightwebapp.services.CountryService;
import com.springproject.lightwebapp.services.StateService;

@Controller
public class StateController {
	
private StateService stateService;
private CountryService countryService;
	
	@Autowired
	public StateController(StateService stateService, CountryService countryService) {
		this.stateService = stateService;
		this.countryService = countryService;
	}
	
	@GetMapping("/state")
	public String getCountries(Model model) {
		List<State> stateList = stateService.getStates();
		
		model.addAttribute("states",stateList);
		
		List<Country> countryList = countryService.getCountries();
		
		model.addAttribute("countries", countryList);
		
		return "state";
		
	}
	
	@PostMapping("/state/addNew")
	public String addNew(State state) {
		stateService.save(state);
		return "redirect:/state";
	}
	
	@RequestMapping("state/findById")
	@ResponseBody
	public Optional<State> findById(Integer id) {
		return stateService.findById(id);
	}
	
	@RequestMapping(value = "/state/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(State state) {
		stateService.save(state);
		return "redirect:/state";
	}
	
	
	@RequestMapping(value = "/state/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id) {
		stateService.delete(id);
		return "redirect:/state";
	}


}

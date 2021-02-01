package com.springproject.lightwebapp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springproject.lightwebapp.models.Country;
import com.springproject.lightwebapp.services.CountryService;

@Controller
public class CountryController {

	private CountryService countryService;
	
	@Autowired
	public CountryController(CountryService countryService) {
		this.countryService = countryService;
	}
	
	@GetMapping("/country")
	public String getCountries(Model model) {
		List<Country> countryList = countryService.getCountries();
		
		model.addAttribute("countries",countryList);
		
		return "country";
		
	}
	
	@PostMapping("/country/addNew")
	public String addNew(Country country) {
		countryService.save(country);
		return "redirect:/country";
	}
	
	@RequestMapping("country/findById")
	@ResponseBody
	public Optional<Country> findById(Integer id) {
		return countryService.findById(id);
	}
	
	@RequestMapping(value = "/country/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(Country country) {
		countryService.save(country);
		return "redirect:/country";
	}
	
	
	
//	@RequestMapping("country/delete")
//	@ResponseBody
//	public String delete(Country country) {
//		countryService.delete(country);
//		
//		return "redirect:/country";
//	}
	
	@RequestMapping(value = "/country/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id) {
		countryService.delete(id);
		return "redirect:/country";
	}

}

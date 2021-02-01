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

import com.springproject.lightwebapp.models.Location;
import com.springproject.lightwebapp.services.CountryService;
import com.springproject.lightwebapp.services.LocationService;
import com.springproject.lightwebapp.services.StateService;

@Controller
//@RequestMapping("/location")
public class LocationController {
	
	@Autowired	private LocationService locationService;
	@Autowired	private CountryService countryService;
	@Autowired	private StateService stateService;
	
	@GetMapping("/location")
	public String findAll(Model model){
		model.addAttribute("locations", locationService.findAll());
		model.addAttribute("countries", countryService.getCountries());
		model.addAttribute("states", stateService.getStates());

		return "location";
	}
	
	@GetMapping("/location/findById")
	@ResponseBody
	public Optional<Location> findById(Integer id) {
		return locationService.findById(id);
	}		
	
//	@GetMapping("/findByDescriptionContaining/{description}")
//	public List<Location> findByDescriptionContaining(@PathVariable("description") String description) {
//		return locationService.findByDescriptionContaining(description);
//	}

	@PostMapping("/location/addNew")
	public String save(Location location) {
		locationService.save(location);
		return "redirect:/location";
	}

	@RequestMapping(value="/location/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(Location location) {
		locationService.save(location);
		return "redirect:/location";
	}
	
	@RequestMapping(value="/location/delete", method = {RequestMethod.DELETE, RequestMethod.GET})	
	public String deleteById(Integer id) {
		locationService.deleteById(id);
		return "redirect:/location";
	}
	
}
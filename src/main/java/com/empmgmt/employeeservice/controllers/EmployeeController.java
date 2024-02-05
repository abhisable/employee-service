package com.empmgmt.employeeservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class EmployeeController {

	@Autowired
	RestTemplate restTemplate;
	@GetMapping("/employee")
	public String getEmployee() {
		String address=restTemplate.getForObject("http://localhost:8080/address", String.class);
		return "I am abhishek sable-123 "+address;
	}
}

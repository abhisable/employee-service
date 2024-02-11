package com.empmgmt.employeeservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.empmgmt.employeeservice.dto.EmployeeDTO;
import com.empmgmt.employeeservice.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/employees")
	public String getEmployee() {
		// String address=restTemplate.getForObject("http://localhost:8080/address",
		// String.class);
		return "I am abhishek sable-123 ";
	}

	@GetMapping("/employees/{id}")
	public ResponseEntity<EmployeeDTO> getEmployeeDetails(@PathVariable("id") int id) {
		return ResponseEntity.status(HttpStatus.OK).body(employeeService.getEmployee(id));
	}
}

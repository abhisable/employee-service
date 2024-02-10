package com.empmgmt.employeeservice.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.empmgmt.employeeservice.dto.AddressDTO;
import com.empmgmt.employeeservice.dto.EmployeeDTO;
import com.empmgmt.employeeservice.entity.EmployeeEntity;
import com.empmgmt.employeeservice.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepo;

	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Value("${addressservice.base.url}")
	private String addressBaseUrl;

	public EmployeeDTO getEmployee(int id) {

		EmployeeEntity employee = employeeRepo.findById(id).get();

		EmployeeDTO empDTO = modelMapper.map(employee, EmployeeDTO.class);
		AddressDTO addressDTO = restTemplate.getForObject(addressBaseUrl+"/address/{id}", AddressDTO.class, id);
		empDTO.setAddressDTO(addressDTO);
		return empDTO;
	}
}

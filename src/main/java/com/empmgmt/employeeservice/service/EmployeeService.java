package com.empmgmt.employeeservice.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.empmgmt.employeeservice.dto.AddressDTO;
import com.empmgmt.employeeservice.dto.EmployeeDTO;
import com.empmgmt.employeeservice.entity.EmployeeEntity;
import com.empmgmt.employeeservice.feignclients.AddressClient;
import com.empmgmt.employeeservice.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepo;

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	AddressClient addressClient;

	@Autowired
	RestTemplate restTemplate;

//	@Autowired
//	DiscoveryClient discoveryClient;
	
	@Autowired
	LoadBalancerClient loadBalancerClient;

	public EmployeeDTO getEmployee(int id) {

		EmployeeEntity employee = employeeRepo.findById(id).get();

		EmployeeDTO empDTO = modelMapper.map(employee, EmployeeDTO.class);
		// AddressDTO addressDTO = addressClient.getAddressByEmployeeId(id);

		AddressDTO addressDTO = getAddressDTO(id);

		empDTO.setAddressDTO(addressDTO);
		return empDTO;
	}

	private AddressDTO getAddressDTO(int id) {

		ServiceInstance instances = loadBalancerClient.choose("address-service");
		String uri = instances.getUri().toString();

		System.out.println("uri is >>>>>>>>>>>>>>>> " + uri);
		return restTemplate.getForObject(uri + "/address-app/api/address/{empId}", AddressDTO.class, id);

	}
}

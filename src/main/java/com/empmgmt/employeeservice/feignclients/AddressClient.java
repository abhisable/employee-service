package com.empmgmt.employeeservice.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.empmgmt.employeeservice.dto.AddressDTO;

@FeignClient(name="address-service",url="http://localhost:8082",path="/address-app/api")
public interface AddressClient {

	@GetMapping("/address/{id}")
	AddressDTO getAddressByEmployeeId(@PathVariable("id") int id);
}

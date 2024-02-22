package com.empmgmt.employeeservice.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.empmgmt.employeeservice.dto.AddressDTO;

//with below tag we can give any name but if we are using it with discovery service it should match 
//with the name of service so that it can fetch host and port for or basically use discovery service

@FeignClient(name="address-service",path="/address-app/api")
public interface AddressClient {

	@GetMapping("/address/{id}")
	AddressDTO getAddressByEmployeeId(@PathVariable("id") int id);
}

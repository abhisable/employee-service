package com.empmgmt.employeeservice.feignclients;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.empmgmt.employeeservice.dto.AddressDTO;

@FeignClient(name="address-service",path="/address-app/api")
@RibbonClient(name= "address-service")
public interface AddressClient {

	@GetMapping("/address/{id}")
	AddressDTO getAddressByEmployeeId(@PathVariable("id") int id);
}

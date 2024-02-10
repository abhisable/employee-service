package com.empmgmt.employeeservice.dto;

import com.empmgmt.employeeservice.entity.EmployeeEntity;

public class EmployeeDTO {

	int id;
	private String name;
	private String email;
	private String bloodGroup;

//	public static EmployeeEntity getEmployeeEntity(EmployeeDTO empDTO) {
//		EmployeeEntity empEntity=new EmployeeEntity();
//		empEntity.setBloodGroup(empDTO.getBloodGroup());
//		empEntity.setEmail(empDTO.getEmail());
//		empEntity.setName(empDTO.getName());
//		return empEntity;
//	}
//	
//	public static EmployeeDTO getEmployeeDTO(EmployeeEntity empEntity) {
//		EmployeeDTO empDTO=new EmployeeDTO();
//		empDTO.setId(empEntity.getId());
//		empDTO.setBloodGroup(empEntity.getBloodGroup());
//		empDTO.setName(empEntity.getName());
//		empDTO.setEmail(empEntity.getEmail());
//		return empDTO;
//	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
}

package com.empmgmt.employeeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empmgmt.employeeservice.entity.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {

}

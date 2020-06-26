package com.angular.spring.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.angular.spring.model.Employee;

@Service
public interface EmployeeService {
	public ResponseEntity<Object> captureEmployeeData(Employee employee);

	public ResponseEntity<Object> retrieveAllEmployee();

	public void removeEmployee(String empId);

	public ResponseEntity<Object> updateEmployee(Employee employee);
}

package com.angular.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.angular.spring.model.AngularModel;
import com.angular.spring.model.Employee;
import com.angular.spring.service.EmployeeService;

@RestController
public class AngularController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(path = "/greeting", method = RequestMethod.GET)
	public ResponseEntity<AngularModel> getData() {
		AngularModel amodel = new AngularModel();
		amodel.setId("AC55175");
		amodel.setContent("Welcome AC55175 - Satish Jainapur");
		
		System.out.println("Exceuting get request");
		
		return new ResponseEntity<AngularModel>(amodel, HttpStatus.OK);
	}
	
	@RequestMapping(path = "employee/postData", method = RequestMethod.POST)
	public ResponseEntity<Object> captureEmployeeData(@RequestBody Employee employee) {
		System.out.println("BEGIN :: capyureEmployeeData() : " + employee);
		
		return employeeService.captureEmployeeData(employee);
	}
	
	@RequestMapping(path = "employee/retrieveAllEmployee", method = RequestMethod.GET)
	public ResponseEntity<Object> retrieveAllEmployee() {
		System.out.println("BEGIN :: retrieveAllEmployee() : ");
		return employeeService.retrieveAllEmployee();
	}
	
	@RequestMapping(path = "employee/delete/{empId}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> removeEmployee(@PathVariable("empId") String empId) {
		System.out.println("BEGIN :: removeEmployee() : ");
		employeeService.removeEmployee(empId);
		return new ResponseEntity<Object>("Employee Deleted successfully", HttpStatus.OK);
	}
	
	@RequestMapping(path = "employee/editEmployeeData" , method = RequestMethod.PUT)
	public ResponseEntity<Object> updateEmployee(@RequestBody Employee employee) {
		System.out.println("BEGIN :: updateEmployee() : ");
		return employeeService.updateEmployee(employee);
	}
}

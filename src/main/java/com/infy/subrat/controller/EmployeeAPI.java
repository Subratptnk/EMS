package com.infy.subrat.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.subrat.model.Employee;
import com.infy.subrat.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeAPI {

	static final Logger logger  = LogManager.getLogger(EmployeeAPI.class.getName());
	
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/{employeeId}")
	public ResponseEntity<Employee> getEmployeeDetails(@PathVariable Long employeeId) throws Exception
	{
		Employee employee = employeeService.getEmployee(employeeId);
		ResponseEntity<Employee> response = new ResponseEntity<Employee>(employee,HttpStatus.OK);
		return response;
	}
	
	
	@PostMapping(value = "/add")
	public ResponseEntity<String> addEmployee(@RequestBody Employee employee) throws Exception
	{
		Long id;
		id = employeeService.addEmployee(employee);
		String successMsg = "Employee with EmployeeId "+id+ " successfully Added";
		ResponseEntity<String> response = new ResponseEntity<String>(successMsg, HttpStatus.CREATED);
		return response;
		
	}
	@PutMapping("/{employeeId}")
	public ResponseEntity<String>updateEmployeeDetails(@PathVariable Long employeeId, @RequestBody Employee employee) throws Exception
	{
		employeeService.updateEmployeeDetails(employeeId, employee.getDepartment());
		String successMessage = "Customer updated successfully.";
		ResponseEntity<String> response = new ResponseEntity<String>(successMessage, HttpStatus.OK);
		return response;
	}
	@DeleteMapping("/{employeeId}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Long employeeId) throws Exception
	{
		employeeService.deleteEmployee(employeeId);
		String successMessage = "Customer deleted succssfully";
		ResponseEntity<String> response = new ResponseEntity<String>(successMessage, HttpStatus.OK);
		return response;
	}
	
}


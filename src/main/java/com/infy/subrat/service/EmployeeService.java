package com.infy.subrat.service;

import com.infy.subrat.model.Employee;

public interface EmployeeService {
	
	public Employee getEmployee(Long employeeId) throws Exception;
	public Long addEmployee(Employee emp);
	public void updateEmployeeDetails(Long employeeId,String department) throws Exception;
	public void deleteEmployee(Long employeeId) throws Exception;
}

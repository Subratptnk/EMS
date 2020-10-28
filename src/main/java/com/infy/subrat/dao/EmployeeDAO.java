package com.infy.subrat.dao;

import com.infy.subrat.model.Employee;

public interface EmployeeDAO {
	
	public Employee getEmployee(Long employeeId);
	public Long addEmployee(Employee emp);
	public void updateEmployeeDetails(Long employeeId,String department);
	public void deleteEmployee(Long employeeId);

}

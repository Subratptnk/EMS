package com.infy.subrat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infy.subrat.dao.EmployeeDAO;
import com.infy.subrat.model.Employee;

@Service(value = "employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	public Employee getEmployee(Long employeeId) throws Exception {
		Employee employee = employeeDAO.getEmployee(employeeId);
		if(employee == null)
			throw new Exception("SERVICE.INVALID_EMPLOYEEID");
		else
			return employee;
	}

	@Override
	public Long addEmployee(Employee emp) {
		
		return employeeDAO.addEmployee(emp);
	}

	@Override
	public void updateEmployeeDetails(Long employeeId,String department) throws Exception {
		Employee employee = employeeDAO.getEmployee(employeeId);
		if(employee == null)
			throw new Exception("SERVICE.INVALID_EMPLOYEEID");
		else
			employeeDAO.updateEmployeeDetails(employeeId, department);
		
	}

	@Override
	public void deleteEmployee(Long employeeId) throws Exception {
		Employee employee = employeeDAO.getEmployee(employeeId);
		if(employee == null)
			throw new Exception("SERVICE.INVALID_EMPLOYEEID");
		else
			employeeDAO.deleteEmployee(employeeId);
		

		
	}
	
	
}

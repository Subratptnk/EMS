package com.infy.subrat.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.infy.subrat.entity.EmployeeEntity;
import com.infy.subrat.model.Employee;

@Repository(value = "employeeDAO")
public class EmployeeDAOImpl implements EmployeeDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Employee getEmployee(Long employeeId) {
		
		EmployeeEntity employeeEntity = entityManager.find(EmployeeEntity.class, employeeId);
		Employee employee = new Employee();
		
		employee.setEmployeeId(employeeEntity.getEmployeeId());
		employee.setEmployeeName(employeeEntity.getEmployeeName());
		employee.setDepartment(employeeEntity.getDepartment());
		employee.setEmail(employeeEntity.getEmail());
		return employee;
	}

	@Override
	public Long addEmployee(Employee emp) {
		
		EmployeeEntity employeeEntity = new EmployeeEntity();
		employeeEntity.setEmployeeId(emp.getEmployeeId());
		employeeEntity.setEmployeeName(emp.getEmployeeName());
		employeeEntity.setDepartment(emp.getDepartment());
		employeeEntity.setEmail(emp.getEmail());
		
		entityManager.persist(employeeEntity);
		return employeeEntity.getEmployeeId();
	}

	@Override
	public void updateEmployeeDetails(Long employeeId, String department) {
		EmployeeEntity employeeEntity = entityManager.find(EmployeeEntity.class, employeeId);
		employeeEntity.setDepartment(department);
	}

	@Override
	public void deleteEmployee(Long employeeId) {
		EmployeeEntity employeeEntity = entityManager.find(EmployeeEntity.class, employeeId);
		entityManager.remove(employeeEntity);
		
	}
	
	
}

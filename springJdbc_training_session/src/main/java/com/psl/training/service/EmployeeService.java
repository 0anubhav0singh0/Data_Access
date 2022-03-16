package com.psl.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;

import com.psl.training.dao.EmployeeDao;
import com.psl.training.model.Employee;

/*
 * We mark beans with @Service to indicate that they're holding the business 
 * logic. Besides being used in the service layer, there isn't any other 
 * special use for this annotation.
 * */

// A class which is responsible to work like a service layer is annotated with @Service
// Interact with dao layer
// may handle transactions
@Service 
public class EmployeeService {
	
	@Autowired
	EmployeeDao dao;
	
	// CURD Operation
	
	public Employee getEmployeeById(int id) {
		return dao.getEmployeeById(id);
	}
	
	// if you want all employees to be return 
	public List<Employee> getAllEmployees(){
		return dao.getAllEmployees();
	}
	
	// which employee you need to insert the employee object will pass here
	public boolean insertEmployee(Employee emp){
		return dao.insertEmployee(emp);
	}
	
	// which employee is update that employee object we will pass here
	public boolean updateEmployee(Employee emp) {
		return false;
	}
	
	// which employee needs to be deleted you will pass employee Id
	public boolean deleteEmployee(int empid) {
		return false;
	}

}

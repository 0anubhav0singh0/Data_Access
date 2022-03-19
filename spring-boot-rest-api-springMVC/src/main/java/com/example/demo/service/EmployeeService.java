package com.example.demo.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EmployeeDao;
import com.psl.training.model.Employee;

@Service
public class EmployeeService {
	@Autowired
	EmployeeDao empRepo;
	
	public Employee getEmployeeById(int id) {
		// if id is not present you can use orElse
		// if present then use get()
		return empRepo.findById(id).orElse(new Employee("ram","Pune",Date.valueOf(LocalDate.now()),23000));
	}
	
	public List<Employee> getAllEmployeesByCity(String city){
		return empRepo.findByCity(city);
	}
	
	public List<Employee> getAllEmployees(){
		return empRepo.findAll();
	}
	
	public Employee insertEmployee(Employee emp) {
		return empRepo.save(emp);
//		return "Employee inserted";
	}
	
	public Employee updateEmployee(Employee emp) {
		return empRepo.save(emp);
//		return "Employee updated";
	}
	
	public String deleteEmployeeById(int id) {
		empRepo.deleteById(id);
		return "Employee deleted";
	}
	
	public int getEmpCount() {
		return empRepo.countOfEmployee();
	}
}

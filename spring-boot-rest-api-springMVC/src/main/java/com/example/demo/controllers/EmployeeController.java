package com.example.demo.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import com.example.demo.service.EmployeeService;
import com.psl.training.model.Employee;

@RestController
@RequestMapping("/employees") // root path
// so whenever you are creating RestAPI whatever your resource PLURAL name of that resource should be used
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	
	@GetMapping("/{id}")
	public Employee getEmpById(@PathVariable("id") int id) {
		return service.getEmployeeById(id);
	}
	
	@GetMapping("/count")
	public int getEmpCount() {
		return service.getEmpCount();
	}
	
	@GetMapping
	public List<Employee> getAllEmployees(@RequestParam(name="city", required=false) String city){
		if(city!=null) {
			return service.getAllEmployeesByCity(city);
		}
		return service.getAllEmployees();
	}
	
	// we are going to get all employee details in request body, which is going to have data of type Employee, that will get capture under emp 
	@PostMapping
	public Employee createEmployee(@RequestBody Employee emp) {
		return service.insertEmployee(emp); // insert employee in database
	}
}

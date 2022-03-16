package com.psl.training.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.psl.training.model.Employee;

//The bean which is interacting with database is called as @Repository

/*
 *@Repository’s job is to catch persistence-specific exceptions and re-throw them as one of Spring’s unified unchecked exceptions.
 *For this, Spring provides PersistenceExceptionTranslationPostProcessor, which we are required to add in our application context 
 *(already included if we're using Spring Boot)
 * */

// A Class is which is responsible for interacting with Data Access Object will be known as a @Repository
// responsibility to get connected to database
@Repository
public class EmployeeDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	// Once JdbcTemplate is created What i can do ?
	// I can Directly insert Employee
	
	// Then you will get a resultset then from resultset you will fetch one by one column, you will set employee value and then you will return employee
	public Employee getEmployeeById(int id) {
		String qry="select * from employee where empid=?";
		// when you will return a resultset, someone should be there who tell your spring how to map your column and properties
		// this mapping can be done with the help of RowMapper, so spring has created a one common class called as a RowMapper
		/*
		 * Query using a prepared statement, reading the ResultSet with a ResultSetExtractor. 
		 * A PreparedStatementCreator can either be implemented directly or configured through a PreparedStatementCreatorFactory.
		 * Specified by: query(...) in JdbcOperations
		 * Type Parameters:<T> 
		 * Parameters:psc a callback that creates a PreparedStatement given a Connection 
		 * rse a callback that will extract results
		 * Returns: an arbitrary result object, as returned by the ResultSetExtractor
		 * */
		return jdbcTemplate.queryForObject(qry, new BeanPropertyRowMapper<Employee>(Employee.class), id);
		// Employee bean should be mapped with Employee classes
		// What it will do ?
		// it will fire a getter and setter method of Employee
		
		// queryForObject for single object to be returned
	}
	
	
	
	// if you want all employees to be return
	public List<Employee> getAllEmployees() {
		String qry="select * from employee";
		return jdbcTemplate.query(qry, new BeanPropertyRowMapper<Employee>(Employee.class));
	}

	
	// which employee you need to insert the employee object will pass here
	public boolean insertEmployee(Employee emp) {
		try {
			String qry = "insert into employee value(?,?,?)";
			jdbcTemplate.update(qry, emp.getEmpid(), emp.getEmpname(), emp.getCity());
		} catch (Exception e) {
			// log an exception
		}
		return false;
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

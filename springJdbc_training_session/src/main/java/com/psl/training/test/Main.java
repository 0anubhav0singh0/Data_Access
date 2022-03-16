package com.psl.training.test;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.psl.training.config.BeanConfig;
import com.psl.training.model.Employee;
import com.psl.training.service.EmployeeService;


public class Main {

	public static void main(String[] args) {
//		ApplicationContext context = new ClassPathXmlApplicationContext("beanConfig.xml");
		ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
		
		///////////////////////// USER WILL INTERACT WITH SERVICE //////////////////////////////////////
		
		Employee emp = new Employee(102, "Anubhav", "Pune");
		
		EmployeeService service = context.getBean(EmployeeService.class);
		
		boolean isInserted = service.insertEmployee(emp);
		System.out.println(isInserted);
		
		System.out.println(service.getEmployeeById(102));
//		System.out.println(context.getBean(DataSource.class));
//		System.out.println(context.getBean(JdbcTemplate.class));
		
		service.getAllEmployees().forEach(System.out::println);
	}

}

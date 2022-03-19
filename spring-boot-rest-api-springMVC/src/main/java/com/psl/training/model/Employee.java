package com.psl.training.model;

import java.sql.Date;

import javax.persistence.*;
//import javax.persistence.GenerationType;

import lombok.*;
//import lombok.NoArgsConstructor;

/*
 * Generates getters for all fields, a useful toString method, and hashCode and equals 
 * implementations that checkall non-transient fields. Will also generate setters for 
 * all non-final fields, as well as a constructor.  
 */

@Data
@NoArgsConstructor // if you want a default constructor to be added
@Entity
@Table(name = "employee_tbl")
public class Employee {
	// this particular will come into picture when you create a table
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empId;

	private String empname;
	private String city;
	private Date joindate;
	private double slary;

	public Employee(String empname, String city, Date joindate, double slary) {
		super();
		this.empname = empname;
		this.city = city;
		this.joindate = joindate;
		this.slary = slary;
	}

}

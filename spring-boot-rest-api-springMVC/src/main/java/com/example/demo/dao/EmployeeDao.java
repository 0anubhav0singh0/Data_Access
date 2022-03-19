package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.psl.training.model.Employee;
//import org.springframework.data.repository.CrudRepository;

//import org.springframework.data.repository.*;

// interface extend always extend another interface
// CrudRepository Interface for generic CRUD operations on a repository for a specific type
// CrudRepository is a standard implementation
// if you sorting that will order by clause or limit query to be added the you can use PagingAndSortingRepository<T.ID>
// PagingAndSortingRepository<T.ID> this is sub interface, On top Repository, from Repository CrudRepository inherited, from CrudRepository PagingAndSortingRepository is inherited, from PagingAndSortingRepository JpaRepository is inherited

// First Parameter Entity Name for which you are creating repository, so it will know to which data, which table has to query or which table data has to be fetched
// Second Parameter is what type of field do you have for the employee ID
// it will be treated as Repository
//@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer>{
	@Query(value = "select count(*) from employee_tbl", nativeQuery=true)
	public int countOfEmployee();
	
	public List<Employee> findByCity(String city);
}

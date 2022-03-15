package com.spring.jdbc.dao;

import com.spring.jdbc.entites.Student;

public interface StudentDao {
	// insert karne ke liye student ka object chaiye hoga
	public int insert(Student student);
	public int Change(Student student);
}

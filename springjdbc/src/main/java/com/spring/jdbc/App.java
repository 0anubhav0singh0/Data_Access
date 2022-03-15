package com.spring.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entites.Student;

/**
 * Hello world!
 * Spring JDBC provide class JdbcTemplate which has all the important  methods to perform operation with database
 *  DataSource --- > basically a interface, source which contain all the information of your databas such as url, pass, driverClass
 *  DriverManagerDataSource implementation class of DataSource
 *  We have to give driverClassName, url, userName, pass to DriverManagerDataSource and then object of this class injected to dataSource property
 *  with help of dataSource JdbcTemplate will connect to our database 
 */
public class App 
{
    public static void main( String[] args )
    {	
        System.out.println( "program started ..........!" );
        ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        // NOT RECOMMENDED WAY OF DOING																	/////
//																											//////
//        JdbcTemplate template = context.getBean("jdbcTemplate",JdbcTemplate.class);						///////
//        																									////////
//        //insert query																					/////////
//        String query = "insert into Student(id, name, city) values(?,?,?)";								/////////
//        																									////////
//        // fire query																						///////
//        int result = template.update(query, 345, "Anubhav", "Delhii");									//////
//        System.out.println("number of records inserted..... " + result);									/////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // StudentDao interface hai (parent hai) StudentDaoImpl
        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
        
        Student student = new Student();
        student.setId(333);
        student.setName("Robi");
        student.setCity("Jalandhar");
        
        int result = studentDao.insert(student);
        System.out.println("student added.... " + result);
        
        // Updating data with the help of spring jdbc
        student.setId(333);
        student.setName("Robiii");
        student.setCity("Phagwara");
        
        int res = studentDao.insert(student);
        System.out.println("student updated.... " + res);
    }
}

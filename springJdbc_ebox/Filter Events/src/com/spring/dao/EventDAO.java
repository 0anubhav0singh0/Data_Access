package com.spring.dao;
// import java.sql.*;
import com.spring.entity.*;
import java.sql.ResultSet;
import java.sql.Types;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import javax.sql.DataSource;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

@Component("eventDAO")
public class EventDAO {
    // Class.forName("oracle.jdbc.OracleDriver");
    @Autowired
    private DataSource datasource;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public DataSource getDataSource(){
        return datasource;
    }
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate= new JdbcTemplate(dataSource);
    }
    
    public List<Event> getAllEvents(){
        String query = "select * from event";
        return jdbcTemplate.query(query, (resultSet, i) -> {
            Event e = new Event();
            e.setId(resultSet.getInt(1));
            e.setEventName(resultSet.getString(2));
            e.setOrganiser(resultSet.getString(3));
            e.setOrganiserNumber(resultSet.getString(4));
            e.setHall(getHallDetail(resultSet.getInt(5)));
            return e;
        });
    }

    public Hall getHallDetail(int id){
        String q = "select * from hall where id = " + id;
        Hall h = jdbcTemplate.queryForObject(q, (resultSet, i) -> {
            Hall hall = new Hall();
            hall.setId(resultSet.getInt(1));
            hall.setName(resultSet.getString(2));
            hall.setLocation(resultSet.getString(3));
            return hall;
        });
        return h;

    }

    public Hall findHallByName(String name){
        String q = "select * from hall where name = " + "'" + name + "'";
        try {
            Hall h = jdbcTemplate.queryForObject(q, new RowMapper<Hall>(){
                @Override
                public Hall mapRow(ResultSet resultSet, int i) throws SQLException {

                    Hall hall = new Hall();
                    hall.setId(resultSet.getInt(1));
                    hall.setName(resultSet.getString(2));
                    hall.setLocation(resultSet.getString(3));
                    return hall;
                }
            });
            return h;
        }
        catch (Exception e) {
            return null;
        }
    }


    public List<Event> findEventsByHallId(int hallId){
        String q = "select * from event where hall_id = " + hallId;
        return jdbcTemplate.query(q, (resultSet, i) -> {
            Event e = new Event();
            e.setId(resultSet.getInt(1));
            e.setEventName(resultSet.getString(2));
            e.setOrganiser(resultSet.getString(3));
            e.setOrganiserNumber(resultSet.getString(4));
            e.setHall(getHallDetail(resultSet.getInt(5)));
            return e;
        });
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}

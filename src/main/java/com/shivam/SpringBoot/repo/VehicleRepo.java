package com.shivam.SpringBoot.repo;

import com.shivam.SpringBoot.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class VehicleRepo {

    // spring framework provides us with a JdbcTemplate, which makes it really easy to connect to a DB using jdbc. It has all the boilercode.
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    
    public JdbcTemplate getTemplate(){
        return jdbcTemplate;
    }

    public VehicleRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Vehicle vehicle){
        // template object is from JdbcTemplate package provided by spring.
        String query = "insert into vehicle (id, name, type) values (?, ?, ?)";
        //similar to executeUpdate when using standard jdbc
        jdbcTemplate.update(query, vehicle.getId(), vehicle.getName(), vehicle.getType());
    }

    public List<Vehicle> getAll(){ 
        return new ArrayList<Vehicle>();     
    }

}

package com.shivam.SpringBoot.repo;

import com.shivam.SpringBoot.model.Vehicle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class VehicleRepo {

    // spring framework provides us with a JdbcTemplate, which makes it really easy to connect to a DB using jdbc. It has all the boilercode.
    private JdbcTemplate template;

    public JdbcTemplate getTemplate() {
        return template;
    }
    
    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }
     
    public void save(Vehicle vehicle){
        //template object is from JdbcTemplate package provided by spring.
        String query = "insert into vehicle (id, name, type) values (?, ?, ?)"; 
        //similar to executeUpdate when using standard jdbc
        int rows = template.update(query, vehicle.getId(), vehicle.getName(), vehicle.getType());
    
        System.out.println(rows + " row(s) affected");
    }

    public List<Vehicle> getAll(){ 
        String query = "select * from vehicle";

        // helps to work with result set from DB one row at a time, instead of a big chunk of data
        // RowMapper<Vehicle> rowMapper = new RowMapper<Vehicle>() {
        //     @Override
        //     public Vehicle mapRow(ResultSet rs, int rowNum) throws SQLException{
                
        //         Vehicle vehicle = new Vehicle();

        //         vehicle.setId(rs.getInt(1)); // getInt takes columnIndex as paramter.
        //         vehicle.setName(rs.getString(2)); // getString takes columnIndex as paramter
        //         vehicle.setType(rs.getString(3));

        //         return vehicle; 

        //     }
        // };


        // converting above code to lambda
        return template.query(query, (rs, rowNum) -> {
                Vehicle vehicle = new Vehicle();
                vehicle.setId(rs.getInt(1)); // getInt takes columnIndex as paramter.
                vehicle.setName(rs.getString(2)); // getString takes columnIndex as paramter
                vehicle.setType(rs.getString(3));
                return vehicle; 
        });
        
        // When lambda is not used
        //rowMapper tells query how to process data
        // List<Vehicle> vehicles = template.query(query, rowMapper);

        // return vehicles;
    }

}

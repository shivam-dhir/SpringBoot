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
        String query = "insert into vehicle (id, vehicle_name, vehicle_type) values (?, ?, ?)"; 
        //similar to executeUpdate when using standard jdbc
        int rows = template.update(query, vehicle.getId(), vehicle.getName(), vehicle.getType());
    
        System.out.println(rows + "row(s) affected");
    }

    public List<Vehicle> getAll(){ 
        return new ArrayList<Vehicle>();     
    }

}

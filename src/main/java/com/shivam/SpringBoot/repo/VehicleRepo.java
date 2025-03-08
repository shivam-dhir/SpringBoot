package com.shivam.SpringBoot.repo;

import com.shivam.SpringBoot.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class VehicleRepo {

    public void save(Vehicle vehicle){
        System.out.println("object saved");
    }

    public List<Vehicle> getAll(){ 
        return new ArrayList<Vehicle>();     
    }

}

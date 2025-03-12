package com.shivam.SpringBoot.model;

import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Scope;

// component annotation is used to create a bean of this class. it adds the class for auto detection and classpath scanning
// scope annotation is used to define the scope of the bean. prototype means a new instance of the bean is created each time it is requested. singleton is the default scope which creates only a single instance of the bean
@Component
@Scope("prototype")
public class Vehicle {

    private int id;
    private String name;
    private String type;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Vehicle [id=" + id + ", name=" + name + ", type=" + type + "]";
    }
    
}

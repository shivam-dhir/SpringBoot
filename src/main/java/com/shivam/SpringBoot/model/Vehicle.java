package com.shivam.SpringBoot.model;

import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Scope;

// component annotation is used to create a bean of this class. it adds the class for auto detection and classpath scanning
@Component
// scope annotation is used to define the scope of the bean. prototype means a new instance of the bean is created each time it is requested. singleton is the default scope which creates only a single instance of the bean
@Scope("prototype")
public class Vehicle {

    private int id;
    private String name;
    private String type;

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setType(String type) {
        this.type = type;
    }
    @Override
    public String toString() {
        return "Vehicle [id=" + id + ", name=" + name + ", type=" + type + "]";
    }

}

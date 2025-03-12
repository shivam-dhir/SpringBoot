package com.shivam.SpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.shivam.SpringBoot.model.Vehicle;
import com.shivam.SpringBoot.repo.VehicleRepo;

@SpringBootApplication
@ComponentScan(basePackages = {"com.shivam.SpringBoot"})
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);

		Vehicle vehicle1 = new Vehicle();
		vehicle1.setId(169);
		vehicle1.setName("Car");
		vehicle1.setType("Four Wheeler");

		VehicleRepo repo = context.getBean(VehicleRepo.class);
		repo.save(vehicle1);

		repo.getAll();
	}

}

package com.cab.booking;

import com.cab.booking.dto.*;
import com.cab.booking.service.DriverService;
import com.cab.booking.service.RideService;
import com.cab.booking.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CabBookingApplication implements CommandLineRunner {
	@Autowired
	private UserService userService;

	@Autowired
	private DriverService driverService;

	@Autowired
	private RideService rideService;

	public static void main(String[] args) {
		SpringApplication.run(CabBookingApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("==================================Onboarding Users==============================================================");
		this.userService.addUser(new User("Abhishek", "M", 23));
		this.userService.addUser(new User("Rahul", "M", 29));
		this.userService.addUser(new User("Nandini", "F", 22));

		System.out.println("==================================Onboarding Drivers============================================================");
		this.driverService.addDriver(new DriverDetail("Driver1","M", 22),new Vehicle("Swift", "KA-01-12345"),new Location(10,1));
		this.driverService.addDriver(new DriverDetail("Driver2","M", 29),new Vehicle("Swift", "KA-01-12345"),new Location(11,10));
		this.driverService.addDriver(new DriverDetail("Driver3","M", 24),new Vehicle("Swift", "KA-01-12345"),new Location(5,3));

		System.out.println("====================================Finding Rides==============================================================");
		System.out.println(this.rideService.findRide("Abhishek",new Location(0,0),new Location(20,1)));
		System.out.println(this.rideService.findRide("Rahul",new Location(10,0),new Location(15,3)));
		System.out.println(this.rideService.findRide("Nandini",new Location(15,6),new Location(20,4)));

		System.out.println("====================================Choosing Rides=============================================================");
		Ride r1 = new Ride("Driver1",new Vehicle("Swift","KA-01-12345"),1);
		Ride r2 = new Ride("Driver4",new Vehicle("Swift","KA-01-12345"),1);
		System.out.println(this.rideService.chooseRide("Rahul",r1));
		System.out.println(this.rideService.chooseRide("Rahul",r2));
		System.out.println(this.rideService.chooseRide("Rahul",r1));
	}
}

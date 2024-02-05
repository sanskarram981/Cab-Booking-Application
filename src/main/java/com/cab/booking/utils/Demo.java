package com.cab.booking.utils;

import com.cab.booking.dto.DriverDetail;
import com.cab.booking.dto.Location;
import com.cab.booking.dto.User;
import com.cab.booking.dto.Vehicle;
import com.cab.booking.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;

public class Demo {
    @Autowired
    private UserService userService;// = new UserServiceImpl();

    @Autowired
    private DriverService driverService;// = new DriverServiceImpl();

    @Autowired
    private RideService rideService;// = new RideServiceImpl();

    public void run()
    {
        this.userService.addUser(new User("Abhishek", "M", 23));
        this.userService.addUser(new User("Rahul", "M", 29));
        this.userService.addUser(new User("Nandini", "F", 22));

        this.driverService.addDriver(new DriverDetail("Driver1","M", 22),new Vehicle("Swift", "KA-01-12345"),new Location(10,1));
        this.driverService.addDriver(new DriverDetail("Driver2","M", 29),new Vehicle("Swift", "KA-01-12345"),new Location(11,10));
        this.driverService.addDriver(new DriverDetail("Driver3","M", 24),new Vehicle("Swift", "KA-01-12345"),new Location(5,3));

        this.rideService.findRide("Abhishek",new Location(0,0),new Location(20,1));
        this.rideService.findRide("Rahul",new Location(10,0),new Location(15,3));
        this.rideService.findRide("Nandini",new Location(15,6),new Location(20,4));

    }
}

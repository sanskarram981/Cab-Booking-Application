package com.cab.booking;

import com.cab.booking.dto.Location;
import com.cab.booking.dto.Ride;
import com.cab.booking.dto.User;
import com.cab.booking.dto.Vehicle;
import com.cab.booking.service.DriverService;
import com.cab.booking.service.RideService;
import com.cab.booking.service.UserService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class CabBookingApplicationTests {

	@Autowired
	private UserService userService;

	@Autowired
	private DriverService driverService;

	@Autowired
	private RideService rideService;
	@Test
	public void TestUserCount()
	{
        assertEquals(3, this.userService.getAllUsers().size());
	}
	@Test
	public void TestDriverCount()
	{
		assertEquals(this.driverService.getAllDrivers().size(),3);
	}

	@Test
	void TestFindRides()
	{
        assertEquals("No ride found", String.valueOf(this.rideService.findRide("Abhishek", new Location(0, 0), new Location(20, 1))));
		assertEquals("No ride found", String.valueOf(this.rideService.findRide("Nandini", new Location(15, 6), new Location(20, 4))));
	}

	@Test
	void TestChooseRides()
	{
		Ride r1 = new Ride("Driver1",new Vehicle("Swift","KA-01-12345"),1);
		Ride r2 = new Ride("Driver4",new Vehicle("Swift","KA-01-12345"),1);
		assertEquals("Ride Selected",this.rideService.chooseRide("Rahul",r1));
		assertEquals("Ride not selected",this.rideService.chooseRide("Rahul",r2));
		assertEquals("Ride not selected",this.rideService.chooseRide("Rahul",r1));
	}


}

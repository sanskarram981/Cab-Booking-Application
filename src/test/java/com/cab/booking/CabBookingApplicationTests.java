package com.cab.booking;

import com.cab.booking.dto.User;
import com.cab.booking.service.DriverService;
import com.cab.booking.service.RideService;
import com.cab.booking.service.UserService;
import org.junit.Before;
import org.junit.BeforeClass;
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
		assertEquals(this.userService.getAllUsers().size(),3);
	}
	@Test
	void TestDriverCount()
	{
		assertEquals(this.driverService.getAllDrivers().size(),3);
	}

}

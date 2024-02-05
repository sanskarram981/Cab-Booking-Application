package com.cab.booking.service;

import com.cab.booking.dto.Driver;
import com.cab.booking.dto.DriverDetail;
import com.cab.booking.dto.Location;
import com.cab.booking.dto.Vehicle;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DriverServiceImpl implements DriverService {

    private List<Driver> drivers = new ArrayList<>();
    @Override
    public void addDriver(DriverDetail driverDetail, Vehicle vehicleDetail, Location currentLocation) {
        Driver driver = new Driver(driverDetail,vehicleDetail,currentLocation,true);
        drivers.add(driver);
        System.out.println("Driver : "+driver + " added successfully");
    }
    public List<Driver> getAllDrivers()
    {
        return this.drivers;
    }
}

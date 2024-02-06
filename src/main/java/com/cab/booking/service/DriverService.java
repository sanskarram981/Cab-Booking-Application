package com.cab.booking.service;

import com.cab.booking.dto.Driver;
import com.cab.booking.dto.DriverDetail;
import com.cab.booking.dto.Location;
import com.cab.booking.dto.Vehicle;

import java.util.List;

public interface DriverService {
    public void addDriver(DriverDetail driverDetail, Vehicle vehicleDetail, Location currentLocation);
    public List<Driver> getAllDrivers();
    public void setAllDrivers(List<Driver> drivers);
}

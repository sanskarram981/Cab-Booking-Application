package com.cab.booking.service;

import com.cab.booking.dto.Driver;
import com.cab.booking.dto.Location;
import com.cab.booking.dto.Ride;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RideServiceImpl implements RideService {
    @Autowired
    private DriverService driverService;
    @Override
    public Object findRide(String userName, Location source, Location destination) {
        List<Driver> drivers = this.driverService.getAllDrivers();
        drivers = drivers.stream().filter(driver -> filterDrivers(source,driver.getCurrentLocation(),driver.isAvailable())).collect(Collectors.toList());
        List<Ride> rides = drivers.stream().map(driver -> new Ride(driver.getDriverDetail().getDriverName(),driver.getVehicle(),findDistance(source,driver.getCurrentLocation()))).collect(Collectors.toList());
        return rides.isEmpty() ? "No ride found" : rides;
    }

    @Override
    public Ride chooseRide(String userName, Ride ride) {
        return null;
    }

    private boolean filterDrivers(Location userLocation,Location driverLocation,Boolean isAvailable)
    {
        return findDistance(userLocation,driverLocation) <= 5 && isAvailable;
    }

    private int findDistance(Location userLocation,Location driverLocation)
    {
        double dx = Math.pow(userLocation.getLongitude()- driverLocation.getLongitude(),2);
        double dy = Math.pow(userLocation.getLatitude()- driverLocation.getLatitude(),2);
        int distance = (int) Math.ceil(Math.sqrt(dx+dy));
        return distance;
    }

}

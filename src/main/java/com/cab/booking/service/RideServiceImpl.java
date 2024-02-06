package com.cab.booking.service;

import com.cab.booking.dto.Driver;
import com.cab.booking.dto.Location;
import com.cab.booking.dto.Ride;
import com.cab.booking.exception.CabBookingException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class RideServiceImpl implements RideService {
    @Autowired
    private DriverService driverService;
    @Override
    public Object findRide(String userName, Location source, Location destination) {
        if(StringUtils.isEmpty(userName) || Objects.isNull(source) || Objects.isNull(destination))
            throw new CabBookingException("invalid/missing details");
        List<Driver> drivers = this.driverService.getAllDrivers();
        if(drivers == null || drivers.isEmpty())
            throw new CabBookingException("no drivers available");
        drivers = drivers.stream().filter(driver -> filterDrivers(source,driver.getCurrentLocation(),driver.isAvailable())).collect(Collectors.toList());
        List<Ride> rides = drivers.stream().map(driver -> new Ride(driver.getDriverDetail().getDriverName(),driver.getVehicle(),findDistance(source,driver.getCurrentLocation()))).collect(Collectors.toList());
        return rides.isEmpty() ? "No ride found" : rides;
    }

    @Override
    public Object chooseRide(String userName, Ride ride) {
        if(StringUtils.isEmpty(userName) || Objects.isNull(ride))
            throw new CabBookingException("invalid/missing details");
         List<Driver> driversAvailable = this.driverService.getAllDrivers().stream().filter(dr -> dr.getDriverDetail().getDriverName().equals(ride.getDriverName()) && dr.isAvailable()).toList();
         if(driversAvailable.isEmpty()) return "Ride not selected";
         Driver driver = driversAvailable.get(0);
         int index = driversAvailable.indexOf(driver);
         driver.setAvailable(false);
         driversAvailable = this.driverService.getAllDrivers();
         driversAvailable.set(index,driver);
         this.driverService.setAllDrivers(driversAvailable);
         return "Ride Selected";
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

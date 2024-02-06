package com.cab.booking.service;

import com.cab.booking.dto.Driver;
import com.cab.booking.dto.DriverDetail;
import com.cab.booking.dto.Location;
import com.cab.booking.dto.Vehicle;
import com.cab.booking.exception.CabBookingException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Service
public class DriverServiceImpl implements DriverService {

    private List<Driver> drivers = new ArrayList<>();
    @Override
    public void addDriver(DriverDetail driverDetail, Vehicle vehicleDetail, Location currentLocation) {
        if(Objects.isNull(driverDetail) || Objects.isNull(vehicleDetail) || Objects.isNull(currentLocation))
            throw new CabBookingException("invalid/missing details");
        Driver driver = new Driver(driverDetail,vehicleDetail,currentLocation,true);
        drivers.add(driver);
        System.out.println("Driver : "+driver + " added successfully");
    }

    @Override
    public List<Driver> getAllDrivers()
    {
        return this.drivers;
    }

    @Override
    public void setAllDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }


}

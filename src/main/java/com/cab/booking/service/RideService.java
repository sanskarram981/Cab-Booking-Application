package com.cab.booking.service;

import com.cab.booking.dto.Location;
import com.cab.booking.dto.Ride;

import java.util.List;

public interface RideService {
    public Object findRide(String userName, Location source, Location destination);
    public Object chooseRide(String userName,Ride ride);
}

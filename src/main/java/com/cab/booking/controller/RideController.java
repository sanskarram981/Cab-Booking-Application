package com.cab.booking.controller;

import com.cab.booking.dto.Ride;
import com.cab.booking.dto.RideRequest;
import com.cab.booking.service.RideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ride")
public class RideController {
    @Autowired
    private RideService rideService;
    @GetMapping("/{username}")
    public ResponseEntity<?> findRide(@PathVariable("username") String username,@RequestBody RideRequest rideRequest)
    {
        return new ResponseEntity<>(this.rideService.findRide(username,rideRequest.getSource(),rideRequest.getDestination()), HttpStatus.OK);
    }

    @PutMapping("/{username}")
    public ResponseEntity<?> chooseRide(@PathVariable("username") String username, @RequestBody Ride ride)
    {
        return new ResponseEntity<>(this.rideService.chooseRide(username,ride),HttpStatus.OK);
    }
}

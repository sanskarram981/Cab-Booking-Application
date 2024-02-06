package com.cab.booking.controller;

import com.cab.booking.dto.*;
import com.cab.booking.service.DriverService;
import com.cab.booking.service.DriverServiceImpl;
import com.cab.booking.service.UserService;
import com.cab.booking.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/driver")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @PostMapping("/add")
    public ResponseEntity<?> addDriver(@RequestBody AddDriverRequest addDriverRequest)
    {
        this.driverService.addDriver(addDriverRequest.getDriverDetail(),addDriverRequest.getVehicleDetail(),addDriverRequest.getCurrentLocation());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}

package com.cab.booking.dto;

public class AddDriverRequest {

    private DriverDetail driverDetail;
    private Vehicle vehicleDetail;
    private Location currentLocation;

    public AddDriverRequest(DriverDetail driverDetail, Vehicle vehicleDetail, Location currentLocation) {
        this.driverDetail = driverDetail;
        this.vehicleDetail = vehicleDetail;
        this.currentLocation = currentLocation;
    }

    public DriverDetail getDriverDetail() {
        return driverDetail;
    }

    public void setDriverDetail(DriverDetail driverDetail) {
        this.driverDetail = driverDetail;
    }

    public Vehicle getVehicleDetail() {
        return vehicleDetail;
    }

    public void setVehicleDetail(Vehicle vehicleDetail) {
        this.vehicleDetail = vehicleDetail;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }
}

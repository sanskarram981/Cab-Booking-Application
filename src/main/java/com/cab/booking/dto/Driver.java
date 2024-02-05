package com.cab.booking.dto;


public class Driver {
    private DriverDetail driverDetail;
    private Vehicle vehicle;
    private Location currentLocation;
    private boolean available;

    public Driver(DriverDetail driverDetail, Vehicle vehicle, Location currentLocation, boolean available) {
        this.driverDetail = driverDetail;
        this.vehicle = vehicle;
        this.currentLocation = currentLocation;
        this.available = available;
    }

    public DriverDetail getDriverDetail() {
        return driverDetail;
    }

    public void setDriverDetail(DriverDetail driverDetail) {
        this.driverDetail = driverDetail;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "driverDetail=" + driverDetail +
                ", vehicle=" + vehicle +
                ", currentLocation=" + currentLocation +
                ", available=" + available +
                '}';
    }
}

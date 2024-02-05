package com.cab.booking.dto;

public class Ride {
    private String driverName;
    private Vehicle vehicle;
    private int driverDistance;

    public Ride(String driverName, Vehicle vehicle, int driverDistance) {
        this.driverName = driverName;
        this.vehicle = vehicle;
        this.driverDistance = driverDistance;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public int getDriverDistance() {
        return driverDistance;
    }

    public void setDriverDistance(int driverDistance) {
        this.driverDistance = driverDistance;
    }

    @Override
    public String toString() {
        return "Ride{" +
                "driverName='" + driverName + '\'' +
                ", vehicle=" + vehicle +
                ", driverDistance=" + driverDistance +
                '}';
    }
}

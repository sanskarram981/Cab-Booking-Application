package com.cab.booking.dto;

public class DriverDetail {
    private String driverName;
    private String driverGender;
    private int driverAge;

    public DriverDetail(String driverName, String driverGender, int driverAge) {
        this.driverName = driverName;
        this.driverGender = driverGender;
        this.driverAge = driverAge;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverGender() {
        return driverGender;
    }

    public void setDriverGender(String driverGender) {
        this.driverGender = driverGender;
    }

    public int getDriverAge() {
        return driverAge;
    }

    public void setDriverAge(int driverAge) {
        this.driverAge = driverAge;
    }

    @Override
    public String toString() {
        return "DriverDetail{" +
                "driverName='" + driverName + '\'' +
                ", driverGender='" + driverGender + '\'' +
                ", driverAge=" + driverAge +
                '}';
    }
}

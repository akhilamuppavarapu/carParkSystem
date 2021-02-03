package com.company;

public class Car {

    private String carRegistration; // T2345 => Capital letter followed by 4 digits
    private String ownerName;
    private boolean isOwnerStaff;

    public Car() {}

    public Car(String carRegistration, String ownerName, boolean isOwnerStaff) {
        this.carRegistration = carRegistration;
        this.ownerName = ownerName;
        this.isOwnerStaff = isOwnerStaff;
    }

    public String getCarRegistration() {
        return carRegistration;
    }

    public void setCarRegistration(String carRegistration) {
        this.carRegistration = carRegistration;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public boolean isOwnerStaff() {
        return isOwnerStaff;
    }

    public void setOwnerStaff(boolean ownerStaff) {
        isOwnerStaff = ownerStaff;
    }

}

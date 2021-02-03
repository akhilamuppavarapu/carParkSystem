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

    public boolean validateCarReg(String carId) {
        boolean isValid;

        if (carId.length() == 5) {
            if (Character.isAlphabetic(carId.codePointAt(0))
                    && Character.isUpperCase(carId.codePointAt(0))) {

                isValid = Character.isDigit(carId.codePointAt(1))
                        && Character.isDigit(carId.codePointAt(2))
                        && Character.isDigit(carId.codePointAt(3))
                        && Character.isDigit(carId.codePointAt(4));

            } else {
                isValid = false;
            }
        } else {
            isValid = false;
        }

        return isValid;

    }


}

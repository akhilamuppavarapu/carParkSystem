package com.company;

public class ParkingSlot {

    private String parkSlotIdentifier; // D01, E27, F16 => Captial letter followed by 2 digits
    private boolean isCarParked;
    private Car parkedCar;
    private String slotType; // will be "visitor" or "staff"

    public ParkingSlot() {}

    public ParkingSlot(String parkSlotIdentifier, boolean isCarParked, Car parkedCar, String slotType) {
        this.parkSlotIdentifier = parkSlotIdentifier;
        this.isCarParked = isCarParked;
        this.parkedCar = parkedCar;
        this.slotType = slotType;
    }

    public String getParkSlotIdentifier() {
        return parkSlotIdentifier;
    }

    public void setParkSlotIdentifier(String parkSlotIdentifier) {
        this.parkSlotIdentifier = parkSlotIdentifier;
    }

    public boolean isCarParked() {
        return isCarParked;
    }

    public void setCarParked(boolean carParked) {
        isCarParked = carParked;
    }

    public Car getParkedCar() {
        return parkedCar;
    }

    public void setParkedCarDetails(Car parkedCar) {
        this.parkedCar = parkedCar;
    }

    public String getSlotType() {
        return slotType;
    }

    public void setSlotType(String slotType) {
        this.slotType = slotType;
    }

    public boolean validateSlotFormat(String slotId) {
        boolean isValid;

        if (slotId.length() == 3) {
            if (Character.isAlphabetic(slotId.codePointAt(0))
                    && Character.isUpperCase(slotId.codePointAt(0))) {

                if (Character.isDigit(slotId.codePointAt(1))
                        && Character.isDigit(slotId.codePointAt(2))) {
                    isValid = true;
                } else {
                    isValid = false;
                }

            } else {
                isValid = false;
            }
        } else {
            isValid = false;
        }

        return isValid;

    }



}

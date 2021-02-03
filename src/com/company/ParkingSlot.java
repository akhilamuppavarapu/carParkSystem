package com.company;

import java.util.ArrayList;

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

    public boolean validateParkingSlotId(String slotId, ArrayList<ParkingSlot> availableSlots, ArrayList<ParkingSlot> occupiedSlots) {
        boolean isValid = false;

        if (validateSlotFormat(slotId)) {
            System.out.println("VALID FORMAT RECEIVED");
            if (availableSlots.size() != 0) {
                for (ParkingSlot parkingSlot: availableSlots) {
                    if (slotId.equals(parkingSlot.getParkSlotIdentifier())) {
                        isValid = false;
                    } else {
                        isValid = true;
                    }
                }
            }

            if (occupiedSlots.size() != 0) {
                for (ParkingSlot parkingSlot1 : occupiedSlots) {
                    if (slotId.equals(parkingSlot1.getParkSlotIdentifier())) {
                        isValid = false;
                    } else {
                        isValid = true;
                    }
                }

            }

            isValid = true;

        } else {
            isValid = false;
        }

        System.out.println("Is it valid?: " + isValid);

        return isValid;
    }


}

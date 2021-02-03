package com.company;

import java.util.ArrayList;

public class CarPark {

    private ArrayList<ParkingSlot> occupiedParkingSlots;
    private ArrayList<ParkingSlot> availableParkingSlots;

    public CarPark() {}

    public CarPark(ArrayList<ParkingSlot> occupiedParkingSlots, ArrayList<ParkingSlot> availableParkingSlots) {
        this.occupiedParkingSlots = occupiedParkingSlots;
        this.availableParkingSlots = availableParkingSlots;
    }

    public ArrayList<ParkingSlot> getOccupiedParkingSlots() {
        return occupiedParkingSlots;
    }

    public void setOccupiedParkingSlots(ArrayList<ParkingSlot> occupiedParkingSlots) {
        this.occupiedParkingSlots = occupiedParkingSlots;
    }

    public ArrayList<ParkingSlot> getAvailableParkingSlots() {
        return availableParkingSlots;
    }

    public void setAvailableParkingSlots(ArrayList<ParkingSlot> availableParkingSlots) {
        this.availableParkingSlots = availableParkingSlots;
    }

}

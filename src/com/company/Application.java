package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Application {

    private CarPark carPark = new CarPark();
    private ArrayList<ParkingSlot> availableParkingSlots = new ArrayList<>();
    private ArrayList<ParkingSlot> occupiedParkingSlots = new ArrayList<>();
    private Application() {}


    public static void main(String[] args) {
        // write your code here
        new Application().startInterface();

    }

    private void startInterface() {
        System.out.println();
        System.out.println();
        System.out.println("PARKING SLOT SYSTEM");
        System.out.println("*************");
        System.out.println("Menu Options");
        System.out.println("1. Add a parking slot");
        System.out.println();
        System.out.println("2. Delete a parking slot by slotId");
        System.out.println();
        System.out.println("3. List all parking slots with details");
        System.out.println();
        System.out.println("4. Park a car into a parking slot");
        System.out.println();
        System.out.println("5. Find a car by registration - show owner and parking slot info");
        System.out.println();
        System.out.println("6. Remove a car");
        System.out.println();
        System.out.println("7. Exit");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int input = Integer.parseInt(bufferedReader.readLine());

            if (input < 0 || input > 7) {
                System.out.println("Invalid selection: Please try again");
            } else if (input == 7) {
                System.out.println("QUITTING");
                System.exit(1);
            } else {
                // We have to handle all other inputs here
                handleInputs(input);
            }
        } catch (IOException e) {
            System.out.println("UNABLE TO READ YOUR INPUT!");
            e.printStackTrace();
            System.exit(1);
        }

    }

    private void handleInputs(int optionNumber) throws IOException {

        switch (optionNumber) {
            case 1:
                // add a parking slot here
                addParkingSlot();
                break;
            case 2:
                // delete the parking slot
                deleteParkingSlot();
                break;
            case 3:
                // print out all parking slots
                listAllParkingSpots();
                break;
            case 4:
                // park a car into a slot
                parkACarIntoSlot();
                break;
            case 5:
                // print car details
                findCarDetails();
                break;
            case 6:
                // delete car from the parking slot
                break;
            default:
                System.out.println("Did not get a proper input");
        }
        startInterface();
    }

    private void findCarDetails() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter car registration number like T2345");
        String carId = bufferedReader.readLine();
        if (new Car().validateCarReg(carId)) {
            for (int i = 0; i < occupiedParkingSlots.size(); i ++) {
                ParkingSlot parkingSlot = occupiedParkingSlots.get(i);
                if (carId.equals(parkingSlot.getParkedCar().getCarRegistration())) {
                    System.out.println("Parking Slot Id: " + parkingSlot.getParkSlotIdentifier());
                    System.out.println("Car Owner: " + parkingSlot.getParkedCar().getOwnerName());
                    System.out.println("Is Staff Car: " + parkingSlot.getParkedCar().isOwnerStaff());
                }
            }
        } else {
            System.out.println("PLEASE ENTER VALID CAR REGISTRATION ID IN THE FORM OF T1234, E7823, ETC");
        }

    }

    private void parkACarIntoSlot() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ParkingSlot parkingSlot = new ParkingSlot();
        System.out.println("Enter parking slot id");
        String psId = bufferedReader.readLine();
        if (parkingSlot.validateSlotFormat(psId)) {
            for (int i = 0; i < availableParkingSlots.size(); i++) {
                ParkingSlot parkingSlot1 = availableParkingSlots.get(i);
                if (psId.equals(parkingSlot1.getParkSlotIdentifier())) {

                    System.out.println("Enter parking slot type: visitor or staff");
                    parkingSlot1.setSlotType(bufferedReader.readLine());

                    parkingSlot1.setCarParked(true);
                    Car car = new Car();
                    System.out.println("Enter car registration number like T2345");
                    String carId = bufferedReader.readLine();

                    if (car.validateCarReg(carId)) {
                        car.setCarRegistration(carId);

                        System.out.println("Enter car owner name");
                        car.setOwnerName(bufferedReader.readLine());

                        System.out.println("Is owner staff member?");
                        System.out.println("Enter Y for YES and N for NO");
                        if (bufferedReader.readLine().equals("Y")) {
                            car.setOwnerStaff(true);
                        } else if (bufferedReader.readLine().equals("N")){
                            car.setOwnerStaff(false);
                        }
                    } else {
                        System.out.println("PLEASE ENTER VALID CAR REGISTRATION ID IN THE FORM OF T1234, E7823, ETC");
                    }
                    parkingSlot1.setParkedCarDetails(car);
                }
                availableParkingSlots.remove(parkingSlot1);
                occupiedParkingSlots.add(parkingSlot1);
            }
        } else {
            System.out.println("PLEASE ENTER VALID PARKING SLOT ID IN THE FORM OF D01, E27, F16, ETC");
        }
        carPark.setAvailableParkingSlots(availableParkingSlots);
        carPark.setOccupiedParkingSlots(occupiedParkingSlots);

    }

    private void listAllParkingSpots() {
        System.out.println("availableParkingSlots.size()");
        System.out.println(availableParkingSlots.size());
        for (ParkingSlot parkingSlot: availableParkingSlots) {
            System.out.println("Slot Id: " + parkingSlot.getParkSlotIdentifier());
            System.out.println("Slot Type: " + parkingSlot.getSlotType());
            System.out.println("Is Slot Occupied? " + parkingSlot.isCarParked());
            System.out.println("**********************");
        }

        System.out.println("occupiedParkingSlots.size()");
        System.out.println(occupiedParkingSlots.size());
        for (ParkingSlot parkingSlot : occupiedParkingSlots) {
            System.out.println("Slot Id: " + parkingSlot.getParkSlotIdentifier());
            System.out.println("Slot Type: " + parkingSlot.getSlotType());
            System.out.println("Is Slot Occupied? " + parkingSlot.isCarParked());
            System.out.println("Car Registration: " + parkingSlot.getParkedCar().getCarRegistration());
            System.out.println("Car Owner: " + parkingSlot.getParkedCar().getOwnerName());
            System.out.println("**********************");

        }

    }

    private void addParkingSlot() throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ParkingSlot parkingSlot = new ParkingSlot();

        System.out.println("Enter parking slot id like D01, E32, etc");
        String psId = bufferedReader.readLine();
        if (parkingSlot.validateParkingSlotId(psId, availableParkingSlots, occupiedParkingSlots)){
            parkingSlot.setParkSlotIdentifier(psId);

            System.out.println("Enter parking slot type: visitor or staff");
            String psType = bufferedReader.readLine();
            parkingSlot.setSlotType(psType);

            System.out.println("Is a car parked in this spot?");
            System.out.println("Enter Y for YES and N for NO");
            String carParked = bufferedReader.readLine();
            if (carParked.equals("N")) {

                parkingSlot.setCarParked(false);
                parkingSlot.setParkedCarDetails(null);
                System.out.println("Thanks!");

            } else if (carParked.equals("Y")) {

                parkingSlot.setCarParked(true);
                Car car = new Car();
                System.out.println("Enter car registration number like T2345");
                String carId = bufferedReader.readLine();

                if (car.validateCarReg(carId)) {
                    car.setCarRegistration(carId);

                    System.out.println("Enter car owner name");
                    car.setOwnerName(bufferedReader.readLine());

                    System.out.println("Is owner staff member?");
                    System.out.println("Enter Y for YES and N for NO");
                    if (bufferedReader.readLine().equals("Y")) {
                        car.setOwnerStaff(true);
                    } else if (bufferedReader.readLine().equals("N")){
                        car.setOwnerStaff(false);
                    }
                } else {
                    System.out.println("PLEASE ENTER VALID CAR REGISTRATION ID IN THE FORM OF T1234, E7823, ETC");
                }
                parkingSlot.setParkedCarDetails(car);
            }
        } else {
            System.out.println("PLEASE ENTER VALID PARKING SLOT ID IN THE FORM OF D01, E27, F16, ETC");
            System.out.println("SLOT ID SHOULD BE UNIQUE AND NOT BE PART OF EXISTING PARKING SLOTS");
        }

        if (parkingSlot.isCarParked()) {
            occupiedParkingSlots.add(parkingSlot);
        } else {
            availableParkingSlots.add(parkingSlot);
        }
        carPark.setAvailableParkingSlots(availableParkingSlots);
        carPark.setOccupiedParkingSlots(occupiedParkingSlots);


    }

    private void deleteParkingSlot() throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter parking slot id to delete");
        String psId = bufferedReader.readLine();
        for (int i = 0; i < availableParkingSlots.size(); i ++) {
            ParkingSlot parkingSlot = availableParkingSlots.get(i);
            if (psId.equals(parkingSlot.getParkSlotIdentifier())) {
                availableParkingSlots.remove(parkingSlot);
                System.out.println("Deleted Parking slot: " + psId);
            }
        }
        carPark.setAvailableParkingSlots(availableParkingSlots);

    }


}

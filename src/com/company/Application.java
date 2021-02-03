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
                break;
            case 2:
                // delete the parking slot
                break;
            case 3:
                // print out all parking slots
                break;
            case 4:
                // park a car into a slot
                break;
            case 5:
                // print car details
                break;
            case 6:
                // delete car from the parking slot
                break;
            default:
                System.out.println("Did not get a proper input");
        }
        startInterface();
    }

}

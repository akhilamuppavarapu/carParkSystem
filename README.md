# Car Parking Sytem

Project encapsulating basic OOP principles in Java which involves creating a command line based car parking monitoring solution.

## Background: 

A small system is required that will help manage cars at a parking site for a company. 
This system should have exactly following four classes:

• Application class
• CarPark class
• ParkingSlot class
• Car class

Application is the Console (Text Based) Interface class including the main() method and
handling all inputs and outputs.

CarPark is responsible for maintaining a list of available parking slots. You should be able to
find a slot, add a slot, delete a slot, and provide a list of all slots included in the car park.

There are two types of parking slots: slots only for visitors and slots only for staff members. A
parking slot must have an identifier, which starts with a capital letter, followed by a two-digit
number e.g. “D01”, “E27”. A parking slot also should know if a car and what car is parked in
the slot. You must be able to add a car to the slot and remove a car from the slot.

A car will be identified by its registration number. A registration number always starts with a
capital letter, followed by a four-digit number e.g. “T2345”. A car should have an owner and
knows if the owner is a staff member.

* No need of maintaining a list of parked cars in any of the classes

## Requirements: 

A menu based interface with the following options:

1. Add a parking slot, all information provided by users
2. Delete a parking slot by slot ID (only if not occupied)
3. List all slots in a well-defined format with information including slot ID, slot type,
whether occupied, and if occupied, show the car registration and the owner.
4. Park a car into a slot (provide slot ID and car information)
5. Find a car by registration number and show the slot and the owner if the car is in
6. Remove a car by registration number
7. Exit


## Pre-Requisites

1. User inputs for menu options, car information, and parking slot information should not
crash the program
2. Parking slot number must be an uppercase letter followed by 2 digits
3. Car registration number must be an uppercase letter followed by 4 digits
4. Each slot should have a unique slot number
5. A parking slot cannot be deleted if there is a car being parked there
6. Visitor car can only be parked in a visitor slot and staff car can only be parked in a
staff slot
7. A car can only be parked in an unoccupied slot
8. A car can only be parked in one slot
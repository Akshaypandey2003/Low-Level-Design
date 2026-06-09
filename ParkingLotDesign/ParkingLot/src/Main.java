import Enums.VehicleType;
import ParkingLot.ParkingLot;
import ParkingLot.Ticket;
import Vehicle.Bike;
import Vehicle.Car;
import Vehicle.Truck;
import Vehicle.Vehicle;

import java.lang.invoke.VarHandle;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to my parking lot, please park your vehicle safely !!");
        //Creating parking lot
        ParkingLot parkingLot = new ParkingLot("PR1234", 2, 6);

        parkingLot.displayFreeCount(VehicleType.CAR);
        parkingLot.displayFreeCount(VehicleType.BIKE);
        parkingLot.displayFreeCount(VehicleType.TRUCK);

        parkingLot.displayFreeSlots(VehicleType.CAR);
        parkingLot.displayFreeSlots(VehicleType.BIKE);
        parkingLot.displayFreeSlots(VehicleType.TRUCK);

        parkingLot.displayOccupiedSlots(VehicleType.CAR);
        parkingLot.displayOccupiedSlots(VehicleType.BIKE);
        parkingLot.displayOccupiedSlots(VehicleType.TRUCK);

        Vehicle car1 = new Car("KA01AB1234", "White");
        Vehicle car2 = new Car("KA01AB1235", "red");
        Vehicle car3 = new Car("KA01AB1236", "green");
        Vehicle car4 = new Car("KA01AB1237", "black");
        Vehicle car5 = new Car("KA01AB1238", "White");
        Vehicle car6 = new Car("KA01AB1239", "gray");
        Vehicle car7 = new Car("KA01AB12301", "blue");




        Ticket t1 = parkingLot.parkVehicle(car1);
        Ticket t2 = parkingLot.parkVehicle(car2);
        Ticket t3 = parkingLot.parkVehicle(car3);
        Ticket t4 = parkingLot.parkVehicle(car4);
        Ticket t5 = parkingLot.parkVehicle(car5);
        Ticket t6 = parkingLot.parkVehicle(car6);
        Ticket t7 = parkingLot.parkVehicle(car7);

        parkingLot.displayFreeCount(VehicleType.CAR);
        parkingLot.displayFreeCount(VehicleType.BIKE);
        parkingLot.displayFreeCount(VehicleType.TRUCK);

        parkingLot.unparkVehicle(t1.getTicketId());
        parkingLot.unparkVehicle(t1.getTicketId());
        parkingLot.unparkVehicle(t2.getTicketId());

        parkingLot.displayFreeCount(VehicleType.CAR);
        parkingLot.displayFreeCount(VehicleType.BIKE);
        parkingLot.displayFreeCount(VehicleType.TRUCK);

        parkingLot.displayFreeSlots(VehicleType.CAR);
        parkingLot.displayFreeSlots(VehicleType.BIKE);
        parkingLot.displayFreeSlots(VehicleType.TRUCK);

        parkingLot.displayOccupiedSlots(VehicleType.CAR);
        parkingLot.displayOccupiedSlots(VehicleType.BIKE);
        parkingLot.displayOccupiedSlots(VehicleType.TRUCK);

        Vehicle bike = new Bike("KA01BK18911", "Black");
        Vehicle truck1 = new Truck("KA01TR97899", "Blue");
        Vehicle truck2 = new Truck("KA01TR95699", "yellow");
        Vehicle truck3 = new Truck("KA01TR02599", "red");

        Ticket t8 = parkingLot.parkVehicle(bike);
        Ticket t9 = parkingLot.parkVehicle(truck1);
        Ticket t10 = parkingLot.parkVehicle(truck2);
        Ticket t11 = parkingLot.parkVehicle(truck3);


        parkingLot.displayFreeCount(VehicleType.CAR);
        parkingLot.displayFreeCount(VehicleType.BIKE);
        parkingLot.displayFreeCount(VehicleType.TRUCK);

        parkingLot.displayFreeSlots(VehicleType.CAR);
        parkingLot.displayFreeSlots(VehicleType.BIKE);
        parkingLot.displayFreeSlots(VehicleType.TRUCK);

        parkingLot.displayOccupiedSlots(VehicleType.CAR);
        parkingLot.displayOccupiedSlots(VehicleType.BIKE);
        parkingLot.displayOccupiedSlots(VehicleType.TRUCK);



    }
}
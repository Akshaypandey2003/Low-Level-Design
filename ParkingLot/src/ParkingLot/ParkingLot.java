package ParkingLot;

import Enums.SlotType;
import Enums.VehicleType;
import Slot.*;
import Vehicle.Vehicle;

import java.util.*;

public class ParkingLot {

    private final String parkingLotId;
    private final List<Floor> floors = new ArrayList<>();
    private final Map<String, Ticket> activeTickets = new HashMap<>();

    public ParkingLot(String parkingLotId, int floorCount, int slotsPerFloor) {
        this.parkingLotId = parkingLotId;

        for (int i = 1; i <= floorCount; i++) {
            floors.add(new Floor(i, slotsPerFloor));
        }
    }

    public Ticket parkVehicle(Vehicle vehicle) {

        for (Floor floor : floors) {

            Slot slot = floor.getFirstFreeSlot(vehicle.getVehicleType());

            if (slot != null) {
                slot.parkVehicle(vehicle);

                String ticketId = parkingLotId + "_" +
                        floor.getFloorNumber() + "_" +
                        slot.getSlotNumber();

                Ticket ticket = new Ticket(ticketId,
                        floor.getFloorNumber(),
                        slot.getSlotNumber(),
                        vehicle);

                activeTickets.put(ticketId, ticket);
                return ticket;
            }
        }

        return null;
    }

    public boolean unparkVehicle(String ticketId) {

        Ticket ticket = activeTickets.get(ticketId);
        if (ticket == null) return false;

        Floor floor = floors.get(ticket.getFloorNumber() - 1);
        List<Integer> occupiedSlots =
                floor.getOccupiedSlots(ticket.getVehicle().getVehicleType());

        for (Object slot :
                floor.getFirstFreeSlot(ticket.getVehicle().getVehicleType()) == null ?
                        Collections.emptyList() :
                        Collections.emptyList());

        floor.getFirstFreeSlot(ticket.getVehicle().getVehicleType());

        activeTickets.remove(ticketId);
        return true;
    }

    public void displayFreeCount(VehicleType type) {
        for (Floor floor : floors) {
            System.out.println("Floor " + floor.getFloorNumber() +
                    " Free Slots: " +
                    floor.getFreeSlotCount(type));
        }
    }

    public void displayFreeSlots(VehicleType type) {
        for (Floor floor : floors) {
            List<Integer> slots = floor.getFreeSlots(type);
            if (!slots.isEmpty()) {
                System.out.println("Floor " +
                        floor.getFloorNumber() +
                        " Free Slots: " + slots);
            }
        }
    }

    public void displayOccupiedSlots(VehicleType type) {
        for (Floor floor : floors) {
            List<Integer> slots = floor.getOccupiedSlots(type);
            if (!slots.isEmpty()) {
                System.out.println("Floor " +
                        floor.getFloorNumber() +
                        " Occupied Slots: " + slots);
            }
        }
    }
}

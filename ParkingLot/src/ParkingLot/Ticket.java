package ParkingLot;

import Slot.Slot;
import Vehicle.Vehicle;


public class Ticket {

    private final String ticketId;
    private final int floorNumber;
    private final int slotNumber;
    private final Vehicle vehicle;

    public Ticket(String ticketId, int floorNumber, int slotNumber, Vehicle vehicle) {
        this.ticketId = ticketId;
        this.floorNumber = floorNumber;
        this.slotNumber = slotNumber;
        this.vehicle = vehicle;
    }

    public String getTicketId() {
        return ticketId;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}

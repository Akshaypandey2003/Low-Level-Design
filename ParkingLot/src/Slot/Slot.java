package Slot;

import Enums.SlotType;
import Enums.VehicleType;
import Vehicle.Vehicle;

public class Slot {

    private final int slotNumber;
    private final VehicleType type;
    private Vehicle parkedVehicle;

    public Slot(int slotNumber, VehicleType type) {
        this.slotNumber = slotNumber;
        this.type = type;
    }

    public boolean isFree() {
        return parkedVehicle == null;
    }

    public void parkVehicle(Vehicle vehicle) {
        this.parkedVehicle = vehicle;
    }

    public void unparkVehicle() {
        this.parkedVehicle = null;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public VehicleType getType() {
        return type;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }

    @Override
    public String toString() {
        return String.valueOf(slotNumber);
    }
}
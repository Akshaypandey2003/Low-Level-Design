package ParkingLot;

import Enums.VehicleType;
import Slot.Slot;

import java.util.*;

public class Floor {

    private final int floorNumber;
    private final Map<VehicleType, List<Slot>> slotsMap = new HashMap<>();

    public Floor(int floorNumber, int totalSlots) {
        this.floorNumber = floorNumber;
        initializeSlots(totalSlots);
    }

    private void initializeSlots(int totalSlots) {

        int slotNumber = 1;

        // First slot -> Truck
        addSlot(slotNumber++, VehicleType.TRUCK);

        // Next 2 slots -> Bike
        for (int i = 0; i < 2 && slotNumber <= totalSlots; i++) {
            addSlot(slotNumber++, VehicleType.BIKE);
        }

        // Remaining -> Car
        while (slotNumber <= totalSlots) {
            addSlot(slotNumber++, VehicleType.CAR);
        }
    }

    private void addSlot(int slotNumber, VehicleType type) {
        slotsMap.putIfAbsent(type, new ArrayList<>());
        slotsMap.get(type).add(new Slot(slotNumber, type));
    }

    public Slot getFirstFreeSlot(VehicleType type) {
        List<Slot> slots = slotsMap.get(type);
        if (slots == null) return null;

        for (Slot slot : slots) {
            if (slot.isFree()) {
                return slot;
            }
        }
        return null;
    }

    public int getFreeSlotCount(VehicleType type) {
        int count = 0;
        List<Slot> slots = slotsMap.get(type);
        if (slots == null) return 0;

        for (Slot slot : slots) {
            if (slot.isFree()) count++;
        }
        return count;
    }

    public List<Integer> getFreeSlots(VehicleType type) {
        List<Integer> result = new ArrayList<>();
        List<Slot> slots = slotsMap.get(type);

        if (slots == null) return result;

        for (Slot slot : slots) {
            if (slot.isFree()) {
                result.add(slot.getSlotNumber());
            }
        }
        return result;
    }

    public List<Integer> getOccupiedSlots(VehicleType type) {
        List<Integer> result = new ArrayList<>();
        List<Slot> slots = slotsMap.get(type);

        if (slots == null) return result;

        for (Slot slot : slots) {
            if (!slot.isFree()) {
                result.add(slot.getSlotNumber());
            }
        }
        return result;
    }

    public int getFloorNumber() {
        return floorNumber;
    }
}


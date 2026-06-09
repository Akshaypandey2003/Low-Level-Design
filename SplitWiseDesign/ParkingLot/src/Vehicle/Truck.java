package Vehicle;

import Enums.VehicleType;

public class Truck extends Vehicle
{
    public Truck(String registrationNumber, String color)
    {
        super(registrationNumber,color, VehicleType.TRUCK);
    }
}

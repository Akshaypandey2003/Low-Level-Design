package Vehicle;

import Enums.VehicleType;

public class Car extends  Vehicle{
    public Car(String registrationNumber, String color)
    {
        super(registrationNumber,color, VehicleType.CAR);
    }
}

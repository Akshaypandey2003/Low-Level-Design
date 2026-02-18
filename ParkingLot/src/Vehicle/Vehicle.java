package Vehicle;

import Enums.VehicleType;

public abstract class Vehicle {

    private VehicleType vehicleType;
    private String registrationNumber;
    private String color;

    public Vehicle(String registrationNumber, String color, VehicleType vehicleType)
    {
        this.registrationNumber = registrationNumber;
        this.color = color;
        this.vehicleType = vehicleType;
    }

    public String getVehicleRegistrationNumber(){return registrationNumber; }

    public String getVehicleColor(){return color;}

    public VehicleType getVehicleType(){return this.vehicleType;}

}

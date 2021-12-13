package main.java.ObjectOriented.parkinglot;

public class Sedan extends Vehicle {
    public Sedan(String licensePlate){
        size = VehicleSize.Sedan;
        this.licensePlate = licensePlate;
    }

    public boolean canFitSpace(ParkingSpace space){
        return space.getSpaceSize() == VehicleSize.Sedan
                || space.getSpaceSize() == VehicleSize.LargeTruck;
    }
}



package main.java.ObjectOriented.parkinglot;

public class LargeTruck extends Vehicle {
    public LargeTruck(String licensePlate){
        size = VehicleSize.LargeTruck;
        this.licensePlate = licensePlate;
    }

    public boolean canFitSpace(ParkingSpace space){
        return size == space.getSpaceSize();
    }
}

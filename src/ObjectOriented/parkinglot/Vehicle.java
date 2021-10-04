package ObjectOriented.parkinglot;

public abstract class Vehicle {
    protected VehicleSize size;
    protected String licensePlate;

    public abstract boolean canFitSpace(ParkingSpace space);

    public VehicleSize getSize(){return this.size;}
}



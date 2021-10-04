package ObjectOriented.parkinglot;

public class Motorcycle extends Vehicle {
    public Motorcycle(String licensePlate) {
        // set the variables that are defined in Vehicle
        // set the spaces that the moto needs, size
        size = VehicleSize.Motorcycle;
        this.licensePlate = licensePlate;
    }
    // implement the abstract methods
    public boolean canFitSpace(ParkingSpace space){
        return true;
    }
}

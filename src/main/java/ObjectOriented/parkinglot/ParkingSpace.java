package main.java.ObjectOriented.parkinglot;

public class ParkingSpace {
    private int spaceNumber;
    private int currentLevel;
    private int row;
    private Vehicle vehicle; // truck,bus, motorcycle
    private VehicleSize spaceSize;

    public ParkingSpace(int spaceNumber, int currentLevel, int row, VehicleSize spaceSize){
        this.spaceNumber = spaceNumber;
        this.currentLevel = currentLevel;
        this.row = row;
        this.spaceSize = spaceSize;
    }

    public VehicleSize getSpaceSize(){
        return spaceSize;
    }

    public boolean checkVehicleFit(Vehicle vehicle){
        return checkSpaceFree() && vehicle.canFitSpace(this);
    }

    public boolean checkSpaceFree(){
         return vehicle == null;
    }

    public boolean park(Vehicle vehicle) {
        if (checkVehicleFit(vehicle)) {
            this.vehicle = vehicle;
            return true;
        }
        return false;
    }

    public Vehicle removeVehicle() {
        Vehicle toReturn = this.vehicle;
        this.vehicle = null;
        return toReturn;
    }
}



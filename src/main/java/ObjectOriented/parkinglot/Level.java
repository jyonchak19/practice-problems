package main.java.ObjectOriented.parkinglot;

public class Level {
    // 3 motorcycles can park in a normal spot
    // 6 motorcycles can park in a large spot
    // normal vehicle can park by taking up 3 small spots
    // 2 normal vehicles can park in a large spot
    // large vehicle can take up 6 small spots or 3 normal spots

    private ParkingSpace[] spaces;
    private int floorLevel;
    private int availableSpaces = 0; // num of free spaces
    private static final int MAX_SPACES_PER_ROW = 10;

    public Level(int floorLevel, int numSpaces) {
        spaces = new ParkingSpace[numSpaces];
        this.floorLevel = floorLevel;
        int largeSpaces = numSpaces / 4; // 25
        int smallSpaces = numSpaces / 4; // 25
        int normalSpaces = numSpaces - largeSpaces - smallSpaces; // 50
        for(int i = 0; i < numSpaces; i++){
            int row = i / MAX_SPACES_PER_ROW;
            VehicleSize size = VehicleSize.Sedan;
            if(i < largeSpaces)
                size = VehicleSize.LargeTruck;
            else if(i < largeSpaces + smallSpaces)
                size = VehicleSize.Motorcycle;

            spaces[i] = new ParkingSpace(i, floorLevel, row, size);
        }
        availableSpaces = numSpaces;
    }
    public int availableSpaces() {
        return availableSpaces;
    }

    private int findAvailableSpaces(Vehicle vehicle) {
        // loop through all of the spaces
        // will check the vehicle and space, see if it fits
        // if it fits, findSpaces will return the index of the spaces
        for(int i = 0; i < spaces.length; i++){
            if(vehicle.canFitSpace(spaces[i])){
                return i;
            }
        }
        return -1;
    }

    // will return true if successful and false if unsuccessful
    public boolean parkVehicle(Vehicle vehicle) {
        // decent amount of logic
        if(availableSpaces == 0)
            return false;
        int parkIndex = findAvailableSpaces(vehicle);
        if (parkIndex < 0)
            return false;
        return spaces[parkIndex].park(vehicle);
    }
}

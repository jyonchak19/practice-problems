package ObjectOriented.parkinglot;

public class ParkingGarage {

    private int numOfLevels;
    private int maxSpacesPerLevel;
    private Level[] levels;
    private static final int MAX_SPOTS_PER_LEVEL = 45;

    public ParkingGarage(int numOfLevels) {
        this(numOfLevels, MAX_SPOTS_PER_LEVEL);
    }

    public ParkingGarage(int numOfLevels, int maxSpacesPerLevel) {
        this.numOfLevels = numOfLevels;
        this.maxSpacesPerLevel = maxSpacesPerLevel;
        levels = new Level[numOfLevels];
        for(int i = 0; i < numOfLevels; i++){
            levels[i] = new Level(i, maxSpacesPerLevel);
        }
    }

    // parks the vehicle in the first level available. return false if failed, return true if success
    public boolean parkVehicle(Vehicle vehicle) {
        for(int i = 0; i < numOfLevels; i++) {
           if(levels[i].parkVehicle(vehicle))
               return true;
        }
        return false;
    }

    public boolean parkVehicleAtLevel(Vehicle vehicle, int level){
        return levels[level].parkVehicle(vehicle);
    }
}



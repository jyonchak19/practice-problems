package ObjectOriented.parkinglot;

import java.util.ArrayList;

public class Driver {
    public static void main(String[] args) {
        // example code calling parking garage
        // init of the entire garage
        ParkingGarage garage = new ParkingGarage(5); // point of confusion - levels number

        // some code that gets the vehicles and inits them

        ArrayList<Vehicle> rafisFleet = new ArrayList<>();
        rafisFleet.add(new Motorcycle("BTC-ETH$$"));
        rafisFleet.add(new LargeTruck("78324893287"));
        rafisFleet.add(new Sedan("84903270hfdkl"));
        rafisFleet.add(new Sedan("432435"));
        rafisFleet.add(new Sedan("878907"));
        rafisFleet.add(new Sedan("54352354"));
        rafisFleet.add(new Sedan("877980789523"));
        rafisFleet.add(new Sedan("dshojh37890jd"));
        // ...

        // large trucks are on the top floor. Sedans cannot be on the top floor.
        // motorcycles can be wherever.
        // for (vehicle in rafisFleet)

        for(Vehicle currVehicle : rafisFleet){
            VehicleSize size = currVehicle.getSize();
            if(size == VehicleSize.Motorcycle)
                garage.parkVehicle(currVehicle);
            if(size == VehicleSize.Sedan)
                parkVehicleExceptRoof(garage, currVehicle);
            if(size == VehicleSize.LargeTruck)
                garage.parkVehicleAtLevel(currVehicle, 4);
        }
    }

    public static boolean parkVehicleExceptRoof(ParkingGarage garage, Vehicle vehicle){
        for(int i = 0; i < 4; i++){
            if(garage.parkVehicleAtLevel(vehicle, i))
                return true;
        }
        return false;
    }
}

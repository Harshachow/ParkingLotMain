import VehicleType.VehicleType;
import VehicleType.Vehicle;
import java.util.ArrayList;
import java.util.List;

public class Level {

    private final List<ParkingSpot> parkingSpots;
    private final int floor;

    public Level(int floor, int numSpots){
        this.floor = floor;
        this.parkingSpots = new ArrayList<>(numSpots);

        double spotsForBike = 0.3;
        double sportForCars = 0.4;

        int numBikeSpots = (int) (numSpots*spotsForBike);
        int numCarSpots = (int) (numSpots*sportForCars);

        for(int i=0;i<numBikeSpots;i++){
            parkingSpots.add(new ParkingSpot(i, VehicleType.MOTORCYCLE));
        }
        for(int i=numBikeSpots;i<numCarSpots;i++){
            parkingSpots.add(new ParkingSpot(i,VehicleType.CAR));
        }
        for(int i =numCarSpots;i< numSpots-(numBikeSpots + numCarSpots);i++){
            parkingSpots.add(new ParkingSpot(i,VehicleType.TRUCK));
        }


    }

    public synchronized boolean parkVechile(Vehicle vehicle){
        for(ParkingSpot spot : parkingSpots){
            if(spot.isAvailable() && vehicle.getType() == spot.getVehicleType()){
                spot.parkVehicle(vehicle);
                return true;
            }

        }
        return  false;
    }

    public synchronized boolean unParkVehicle(Vehicle vehicle){
        for(ParkingSpot spot : parkingSpots){
            if(!spot.isAvailable() && spot.getParkedVehicle().equals(vehicle) ) {
                spot.unParkVehicle();
                return true;
            }
        }
        return false;
    }

    public void displayAvailability(){
        System.out.println("Available spots in level - " + floor + " are");
        for(ParkingSpot spot : parkingSpots){
            System.out.println("spot" + spot.getSpotNumber() + ":" + (spot.isAvailable() ? "is avaiable for" : "is ocupiyed by")+spot.getVehicleType());
        }
    }
}

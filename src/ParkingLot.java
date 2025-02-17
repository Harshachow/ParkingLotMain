import VehicleType.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private static ParkingLot instance;
    private final List<Level> levels;

    private ParkingLot(){
        levels = new ArrayList<>();

    }

    public static synchronized ParkingLot getInstance(){
        if(instance == null){
            return new ParkingLot();
        }
        return instance;
    }

    public void addLevel(Level level){
        levels.add(level);
    }

    public boolean parkVehicle(Vehicle vehicle){
        for(Level level : levels){
            if(level.parkVechile(vehicle)){
                System.out.println("pakring is successfull");
                return true;
            }
        }
        System.out.println("No space available");
        return false;
    }
    public  boolean unParkVehicle(Vehicle vehicle){
        for(Level level : levels){
            if(level.unParkVehicle(vehicle)){
                System.out.println("unparked the vehicle");
                return true;
            }
        }
        return false;
    }

    public void displayAvailability(){
        for(Level level : levels){
            level.displayAvailability();
        }
    }
}

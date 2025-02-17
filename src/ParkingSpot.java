import VehicleType.VehicleType;
import VehicleType.Vehicle;

public class ParkingSpot {

    private Integer spotNumber;
    private final VehicleType vehicleType;
    private Vehicle parkedVehicle;

    public ParkingSpot(Integer spotNumber, VehicleType vehicleType){
        this.spotNumber = spotNumber;
        this.vehicleType = vehicleType;
    }
    public synchronized boolean isAvailable(){
       return parkedVehicle == null;
    }
    public synchronized void parkVehicle(Vehicle vehicle){
            if(isAvailable() && vehicle.getType() == vehicleType){
                parkedVehicle = vehicle;
            }
            else {
                throw new IllegalArgumentException("Invalid Vehicle type or spot is occupied");
            }
    }

    public synchronized void unParkVehicle(){
        parkedVehicle = null;
    }

    public Integer getSpotNumber() {
        return spotNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }
}


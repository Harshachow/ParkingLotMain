import VehicleType.Car;
import VehicleType.MotorCycle;
import VehicleType.Truck;
import VehicleType.Vehicle;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ParkingLot parkingLot = ParkingLot.getInstance();

        parkingLot.addLevel(new Level(1,10));
        parkingLot.addLevel(new Level(2,8));

        Vehicle car = new Car("23");
        Vehicle motorCycle = new MotorCycle("34");
        Vehicle truck = new Truck("45");

        parkingLot.parkVehicle(car);
        parkingLot.parkVehicle(motorCycle);
        parkingLot.parkVehicle(truck);
        parkingLot.displayAvailability();
        parkingLot.unParkVehicle(car);
        parkingLot.unParkVehicle(truck);
        parkingLot.displayAvailability();
    }
}
package VehicleType;

public abstract class Vehicle {
    protected String licensePLate;
    protected VehicleType type;

    public Vehicle(String licensePLate, VehicleType type){
        this.licensePLate = licensePLate;
        this.type = type;
    }

    public VehicleType getType() {
        return type;
    }
}

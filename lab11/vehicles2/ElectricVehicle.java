package ro.utcluj.aut.isp.vehicles2;

public class ElectricVehicle extends Vehicle {
    public ElectricVehicle(String type, int length) {
        super(type, length);
    }
    public String start(){
        return "electric engine started";
    }
}
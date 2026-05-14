package lesson_2026_05_14;
class ParkingArea {
    private Vehicle[] vehicles;
    public ParkingArea(int size) {
        vehicles = new Vehicle[size];
    }
    public int addVehicle(Vehicle v) {
        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i] == null) {
                vehicles[i] = v;
                return i;
            }
        }
        return -1;
    }
    public Vehicle removeVehicle(String registration) {
        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i] != null && vehicles[i].getRegistration().equals(registration)) {
                Vehicle remove = vehicles[i];
                vehicles[i] = null;
                return remove;
            }
        }
        return null;
    }
}
class Vehicle {
    private String registration;
    private byte colour;
    private boolean broken;
    public final static byte BLACK = 1;
    public final static byte WHITE = 2;
    public final static byte BLUE = 3;
    public final static byte RED = 4;
    public final static byte GREEN = 5;
    private final static double ADMIN_FEE = 3;
    public Vehicle() {
    }

    public Vehicle(String registration) {
        this.registration = registration;
    }

    public Vehicle(String registration, byte colour) {
        this.registration = registration;
        this.colour = colour;
    }

    public void setBroken(boolean broken) {
        this.broken = broken;
    }

    public void setColour(byte colour) {
        this.colour = colour;
    }

    public boolean getBroken() {
        return broken;
    }

    public String getRegistration() {
        return registration;
    }

    public double pay(int hours) {
        if (hours <= 5) return ADMIN_FEE;

        else {
            return 0;
        }
    }
}
class Car extends Vehicle {
    public static double hourlyFee = 3.5;

    public double pay(int hours) {
        return super.pay(hours) + (hourlyFee * hours);
    }
}
class Motorbike extends Vehicle{
    public static double hourlyFee=2.5;
    public double pay(int hours) {
        return super.pay(hours) + (hourlyFee * hours);
    }
}
public class VehiclesDemo {
    public static void main(String[] args){
        Vehicle X = new Vehicle("X1234567");
        X.setColour(Vehicle.BLACK);
    }
}




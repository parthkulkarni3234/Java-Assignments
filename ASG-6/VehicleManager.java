class Vehicle {
    private String vehicleName = "Tesla Model X";
    private String vehicleType = "Electric Car";

    // Inner Class
    class VehicleDetails {
        void display() {
            System.out.println("Vehicle Name: " + vehicleName);
            System.out.println("Vehicle Type: " + vehicleType);
        }
    }
}

interface Action {
    void performAction();
}

public class VehicleManager {
    public static void main(String[] args) {
        // Inner Class
        Vehicle vehicle = new Vehicle();
        Vehicle.VehicleDetails details = vehicle.new VehicleDetails();
        details.display();

        // Anonymous Class
        Action action = new Action() {
            public void performAction() {
                System.out.println("Vehicle is starting the engine...");
            }
        };
        action.performAction();
    }
}
class Vehicle {
    String vehicleNumber;
    String vehicleModel;

    Vehicle(String vehicleNumber, String vehicleModel) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleModel = vehicleModel;
    }

    void displayVehicleInfo() {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Vehicle Model: " + vehicleModel);
    }
}

class CarInsurance extends Vehicle {
    double premiumAmount;

    CarInsurance(String vehicleNumber, String vehicleModel, double premiumAmount) {
        super(vehicleNumber, vehicleModel);
        this.premiumAmount = premiumAmount;
    }

    void displayInsuranceInfo() {
        super.displayVehicleInfo();
        System.out.println("Premium Amount: " + premiumAmount);
    }
}

class BikeInsurance extends Vehicle {
    double premiumAmount;

    BikeInsurance(String vehicleNumber, String vehicleModel, double premiumAmount) {
        super(vehicleNumber, vehicleModel);
        this.premiumAmount = premiumAmount;
    }

    void displayInsuranceInfo() {
        super.displayVehicleInfo();
        System.out.println("Premium Amount: " + premiumAmount);
    }
}

public class InsuranceSystem {
    public static void main(String[] args) {
        CarInsurance car = new CarInsurance("MH12AB1234", "Honda City", 12500.0);
        BikeInsurance bike = new BikeInsurance("MH14CD5678", "Royal Enfield", 4500.0);

        System.out.println("--- Car Insurance ---");
        car.displayInsuranceInfo();

        System.out.println("\n--- Bike Insurance ---");
        bike.displayInsuranceInfo();
    }
}
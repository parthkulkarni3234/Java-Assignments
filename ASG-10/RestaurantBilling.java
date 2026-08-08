abstract class FoodOrder {
    abstract double calculateBill();
}

class DineInOrder extends FoodOrder {
    double baseAmount;
    double serviceCharge;

    DineInOrder(double baseAmount, double serviceCharge) {
        this.baseAmount = baseAmount;
        this.serviceCharge = serviceCharge;
    }

    double calculateBill() {
        return baseAmount + serviceCharge;
    }
}

class TakeAwayOrder extends FoodOrder {
    double baseAmount;
    double packagingCharge;

    TakeAwayOrder(double baseAmount, double packagingCharge) {
        this.baseAmount = baseAmount;
        this.packagingCharge = packagingCharge;
    }

    double calculateBill() {
        return baseAmount + packagingCharge;
    }
}

public class RestaurantBilling {
    public static void main(String[] args) {
        FoodOrder dineIn = new DineInOrder(3000.0, 80.0);
        System.out.println("Dine-In Total Bill: Rs. " + dineIn.calculateBill());

        FoodOrder takeAway = new TakeAwayOrder(6100.0, 20.0);
        System.out.println("Take-Away Total Bill: Rs. " + takeAway.calculateBill());
    }
}
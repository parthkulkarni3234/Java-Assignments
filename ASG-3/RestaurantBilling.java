public class RestaurantBilling {

    // Static variable 
    static int totalOrders = 0;

    // Overloaded method 
    public double calculateBill(double amount, String type) {
        totalOrders++;
        double serviceCharge = amount * 0.15; // 15% service charge
        return amount + serviceCharge;
    }

    // Overloaded method - takeaway bill (no extra charge)
    public double calculateBill(double amount) {
        totalOrders++;
        return amount;
    }

    // Overloaded method - delivery bill (adds delivery fee)
    public double calculateBill(double amount, double deliveryFee) {
        totalOrders++;
        return amount + deliveryFee;
    }

    public static void main(String[] args) {

        RestaurantBilling billing = new RestaurantBilling();

        double dineInBill = billing.calculateBill(1000.0, "dine-in");
        double takeawayBill = billing.calculateBill(500.0);
        double deliveryBill = billing.calculateBill(700.0, 50.0);

        System.out.println("Dine-in Bill (15% service charge included): Rs. " + dineInBill);
        System.out.println("Takeaway Bill: Rs. " + takeawayBill);
        System.out.println("Delivery Bill (with delivery fee): Rs. " + deliveryBill);

        // Static variable
        System.out.println("Total Orders Processed: " + totalOrders);
    }
}
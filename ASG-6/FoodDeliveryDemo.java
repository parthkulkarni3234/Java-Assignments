class FoodOrder {
    private String orderId = "ORD1001";
    private String itemName = "Chicken Biryani";

    // Inner Class
    class OrderDetails {
        void display() {
            System.out.println("Order ID: " + orderId);
            System.out.println("Item: " + itemName);
        }
    }
}

interface DeliveryStatus {
    void updateStatus();
}

public class FoodDeliveryDemo {
    public static void main(String[] args) {
        // Inner Class
        FoodOrder order = new FoodOrder();
        FoodOrder.OrderDetails orderDetails = order.new OrderDetails();
        orderDetails.display();

        // Anonymous Class 1
        DeliveryStatus outForDelivery = new DeliveryStatus() {
            public void updateStatus() {
                System.out.println("Status: Order is out for delivery");
            }
        };
        outForDelivery.updateStatus();

        // Anonymous Class 2
        DeliveryStatus delivered = new DeliveryStatus() {
            public void updateStatus() {
                System.out.println("Status: Order has been delivered");
            }
        };
        delivered.updateStatus();
    }
}
public class MobilePhone {

    // Variables
    String brand;
    String model;
    double price;

    // Default constructor
    public MobilePhone() {
        brand = "Unknown";
        model = "Unknown";
        price = 0.0;
    }

    // Parameterized constructor
    public MobilePhone(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    // Copy constructor - creates a duplicate object from an existing one
    public MobilePhone(MobilePhone m) {
        this.brand = m.brand;
        this.model = m.model;
        this.price = m.price;
    }

    // Method to display phone details
    public void display() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Price: Rs. " + price);
    }

    public static void main(String[] args) {

        // Default constructor
        MobilePhone phone1 = new MobilePhone();

        // Parameterized constructor
        MobilePhone phone2 = new MobilePhone("Samsung", "Galaxy S24 Fe", 74999.0);

        // Copy constructor - duplicates phone2's data into phone3
        MobilePhone phone3 = new MobilePhone(phone2);

        System.out.println("Phone 1 (Default):");
        phone1.display();

        System.out.println("Phone 2 (Parameterized):");
        phone2.display();

        System.out.println("Phone 3 (Copy of Phone 2):");
        phone3.display();
    }
}
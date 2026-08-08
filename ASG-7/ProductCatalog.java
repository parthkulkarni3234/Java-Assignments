interface Product {
    void displayDetails();
}

class Item {
    String name;
    double price;

    Item(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class Electronic extends Item implements Product {
    String warranty;

    Electronic(String name, double price, String warranty) {
        super(name, price);
        this.warranty = warranty;
    }

    public void displayDetails() {
        System.out.println("Electronic Item: " + name + ", Price: " + price + ", Warranty: " + warranty);
    }
}

class Clothing extends Item implements Product {
    String size;

    Clothing(String name, double price, String size) {
        super(name, price);
        this.size = size;
    }

    public void displayDetails() {
        System.out.println("Clothing Item: " + name + ", Price: " + price + ", Size: " + size);
    }
}

class Grocery extends Item implements Product {
    String expiryDate;

    Grocery(String name, double price, String expiryDate) {
        super(name, price);
        this.expiryDate = expiryDate;
    }

    public void displayDetails() {
        System.out.println("Grocery Item: " + name + ", Price: " + price + ", Expiry Date: " + expiryDate);
    }
}

public class ProductCatalog {
    public static void main(String[] args) {
        Product laptop = new Electronic("One plus Nord CE-5", 25000.0, "2 Years");
        Product shirt = new Clothing("Jeans", 3999.0, "XL");
        Product rice = new Grocery("Wheat", 99.0, "12/2026");

        laptop.displayDetails();
        shirt.displayDetails();
        rice.displayDetails();
    }
}
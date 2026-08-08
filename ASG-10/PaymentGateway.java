abstract class Payment {
    abstract void processPayment(double amount);
}

class CreditCardPayment extends Payment {
    String cardNumber;

    CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    void processPayment(double amount) {
        System.out.println("Processing Credit Card payment of Rs. " + amount);
        System.out.println("Card Number: " + cardNumber);
    }
}

class UpiPayment extends Payment {
    String upiId;

    UpiPayment(String upiId) {
        this.upiId = upiId;
    }

    void processPayment(double amount) {
        System.out.println("Processing UPI payment of Rs. " + amount);
        System.out.println("UPI ID: " + upiId);
    }
}

public class PaymentGateway {
    public static void main(String[] args) {
        Payment payment1 = new CreditCardPayment("4532 1122 3344 5566");
        payment1.processPayment(2500.0);

        System.out.println();

        Payment payment2 = new UpiPayment("parth@okhdfcbank");
        payment2.processPayment(7000.0);
    }
}
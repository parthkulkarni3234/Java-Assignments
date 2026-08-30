import java.util.Scanner;

public class ATM_PIN {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter ATM PIN: ");
            int pin = sc.nextInt();

            if (pin != 2658) {
                throw new Exception("Invalid PIN.");
            }

            System.out.println("PIN verified successfully.");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());

        } finally {
            System.out.println("PIN verification process completed.");
        }

        sc.close();
    }
}
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class TemperatureClientLauncher {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        TemperatureConverterService service = (TemperatureConverterService) registry.lookup("TempService");
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter temperature in Celsius: ");
        double c = sc.nextDouble();
        System.out.println("In Fahrenheit: " + service.cToF(c));

        System.out.print("Enter temperature in Fahrenheit: ");
        double f = sc.nextDouble();
        System.out.println("In Celsius: " + service.fToC(f));
    }
}
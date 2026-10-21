import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculatorClientLauncher {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        CalculatorService calc = (CalculatorService) registry.lookup("CalculatorService");
        System.out.println("Addition (10 + 5): " + calc.add(10, 5));
        System.out.println("Subtraction (10 - 5): " + calc.sub(10, 5));
    }
}
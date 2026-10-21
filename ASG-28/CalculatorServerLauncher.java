import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculatorServerLauncher {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.rebind("CalculatorService", new CalculatorServiceImpl());
        System.out.println("Calculator Server Ready");
    }
}                               
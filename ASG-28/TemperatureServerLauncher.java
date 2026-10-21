import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class TemperatureServerLauncher {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.rebind("TempService", new TemperatureConverterServiceImpl());
        System.out.println("Temperature Converter Server Ready");
    }
}
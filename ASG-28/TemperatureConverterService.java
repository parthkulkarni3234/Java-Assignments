import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TemperatureConverterService extends Remote {
    double cToF(double c) throws RemoteException;
    double fToC(double f) throws RemoteException;
}
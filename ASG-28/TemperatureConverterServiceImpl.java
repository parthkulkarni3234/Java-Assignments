import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class TemperatureConverterServiceImpl extends UnicastRemoteObject implements TemperatureConverterService {
    public TemperatureConverterServiceImpl() throws RemoteException {
        super();
    }

    public double cToF(double c) throws RemoteException {
        return (c * 9 / 5) + 32;
    }

    public double fToC(double f) throws RemoteException {
        return (f - 32) * 5 / 9;
    }
}
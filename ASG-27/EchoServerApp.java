import java.io.*;
import java.net.*;

public class EchoServerApp {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(6000);
        Socket s = ss.accept();
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);

        String message = in.readLine();
        out.println("Echo: " + message);

        in.close();
        out.close();
        s.close();
        ss.close();
    }
}
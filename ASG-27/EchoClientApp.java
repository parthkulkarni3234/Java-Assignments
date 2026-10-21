import java.io.*;
import java.net.*;

public class EchoClientApp {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 6000);
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter message: ");
        String msg = stdin.readLine();
        out.println(msg);

        String response = in.readLine();
        System.out.println(response);

        in.close();
        out.close();
        s.close();
    }
}
import java.io.*;
import java.net.*;

public class ChatClientApp {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 5000);
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String strIn = "", strOut = "";
        while (!strOut.equals("stop")) {
            strOut = br.readLine();
            dout.writeUTF(strOut);
            dout.flush();
            strIn = din.readUTF();
            System.out.println("Server says: " + strIn);
        }
        dout.close();
        din.close();
        s.close();
    }
}
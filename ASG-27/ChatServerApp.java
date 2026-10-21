import java.io.*;
import java.net.*;

public class ChatServerApp {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(5000);
        Socket s = ss.accept();
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String strIn = "", strOut = "";
        while (!strIn.equals("stop")) {
            strIn = din.readUTF();
            System.out.println("Client says: " + strIn);
            strOut = br.readLine();
            dout.writeUTF(strOut);
            dout.flush();
        }
        din.close();
        dout.close();
        s.close();
        ss.close();
    }
}
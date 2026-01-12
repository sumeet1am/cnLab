import java.net.*;
import java.io.*;

public class TCPC {
    public static void main(String[] args) throws Exception {

        Socket socket = new Socket("127.0.0.1", 4000);

        BufferedReader kb = new BufferedReader(
                new InputStreamReader(System.in));
        System.out.println("Enter the filename");
        String fileName = kb.readLine();

        PrintWriter out = new PrintWriter(
                socket.getOutputStream(), true);
        out.println(fileName);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));

        String line;
        while ((line = in.readLine()) != null) {
            System.out.println(line);
        }

        socket.close();
    }
}

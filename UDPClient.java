import java.net.*;
import java.io.*;

public class UDPClient {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        DatagramSocket ds = new DatagramSocket();
        InetAddress ip = InetAddress.getByName("localhost");

        System.out.println("Enter the string in lowercase so that you receive the message in Uppercase from the server");
        byte[] send = br.readLine().getBytes();

        DatagramPacket dp = new DatagramPacket(send, send.length, ip, 9876);
        ds.send(dp);

        byte[] buf = new byte[1024];
        DatagramPacket reply = new DatagramPacket(buf, buf.length);
        ds.receive(reply);

        System.out.println("FROM SERVER: " +
                new String(reply.getData(), 0, reply.getLength()));

        ds.close();
    }
}

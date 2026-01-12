import java.net.*;

public class UDPServer {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket(9876);
        System.out.println("Server is Ready for the client");

        byte[] buf = new byte[1024];

        while (true) {
            DatagramPacket dp = new DatagramPacket(buf, buf.length);
            ds.receive(dp);

            String msg = new String(dp.getData(), 0, dp.getLength());
            System.out.println("RECEIVED: " + msg);

            byte[] send = msg.toUpperCase().getBytes();
            DatagramPacket reply = new DatagramPacket(
                    send, send.length, dp.getAddress(), dp.getPort());
            ds.send(reply);
        }
    }
}

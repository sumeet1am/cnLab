import java.util.*;

public class RED {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        System.out.println("Enter the maximum number of packets:");
        int packets = sc.nextInt();

        System.out.println("Enter the queue size:");
        int qSize = sc.nextInt();

        System.out.println("Enter the maximum probability:");
        double maxP = sc.nextDouble();

        System.out.println("Enter the minimum probability:");
        double minP = sc.nextDouble();

        System.out.println("Enter the threshold value:");
        int th = sc.nextInt();

        int qLen = 0;

        for (int i = 1; i <= packets; i++) {
            double dropP = minP + 
                (maxP - minP) * (qLen - th) / (qSize - th);

            if (qLen >= th && r.nextDouble() < dropP) {
                System.out.println("Packet dropped (CONGESTION AVOIDANCE)");
            } else {
                System.out.println("Packet accepted " + i);
                qLen++;
            }
        }
    }
}

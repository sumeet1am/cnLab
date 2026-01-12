import java.util.*;

public class LeakyBucket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the bucket capacity\n");
        int cap = sc.nextInt();

        System.out.print("Enter the bucket rate (Rate at which the bucket sends the packets)\n");
        int rate = sc.nextInt();

        System.out.print("Enter the number of packets to be sent\n");
        int n = sc.nextInt();

        int[] pkt = new int[n];
        System.out.println("Enter the packets sizes one by one");
        for (int i = 0; i < n; i++)
            pkt[i] = sc.nextInt();

        int rem = 0;
        System.out.println("\nTime_t\tP_size\taccepted\tsent\tremaining");

        for (int i = 0; i < n; i++) {
            int accept = (rem + pkt[i] <= cap) ? pkt[i] : -1;

            if (accept != -1) rem += accept;

            int sent = Math.min(rem, rate);
            rem -= sent;

            if (accept == -1)
                System.out.println((i+1)+"\t"+pkt[i]+"\tdropped\t\t"+sent+"\t"+rem);
            else
                System.out.println((i+1)+"\t"+pkt[i]+"\t"+accept+"\t\t"+sent+"\t"+rem);
        }
    }
}

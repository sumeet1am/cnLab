import java.util.*;

public class TokenBucket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the bucket capacity");
        int cap = sc.nextInt();

        System.out.println("Enter the Token generation rate (Rate at which tokens are sent to the bucket)");
        int rate = sc.nextInt();

        System.out.println("Enter the number of Cycles the host computer sends the Tokens to the bucket(at constant rate)");
        int n = sc.nextInt();

        int tokens = 0;
        System.out.println("\nTime_t\tTokens Requested\tTokens Sent\tTokens Remaining in bucket");

        for (int i = 0; i < n; i++) {
            int req = rate;
            int sent = Math.min(req, cap - tokens);
            tokens += sent;

            System.out.println((i+1) + "\t\t" + req + "\t\t\t" + sent + "\t\t" + tokens);
        }
    }
}

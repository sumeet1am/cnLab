import java.util.*;

public class SortFrames {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        System.out.print("Enter number of frames: ");
        int n = sc.nextInt();

        List<int[]> frames = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter data for frame " + (i + 1) + ": ");
            frames.add(new int[]{r.nextInt(1000) + 1, sc.nextInt()});
        }

        System.out.println("\nBefore Sorting:");
        for (int[] f : frames)
            System.out.println("SeqNum=" + f[0] + ", Data=" + f[1]);

        frames.sort(Comparator.comparingInt(a -> a[0]));

        System.out.println("\nAfter Sorting:");
        for (int[] f : frames)
            System.out.println("SeqNum=" + f[0] + ", Data=" + f[1]);
    }
}

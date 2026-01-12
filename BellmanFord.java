import java.util.*;

public class BellmanFord {
    static int N;
    static int[][] g;

    static void bellmanFord(int src) {
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int k = 1; k < N; k++)
            for (int u = 0; u < N; u++)
                for (int v = 0; v < N; v++)
                    if (g[u][v] != 0 && dist[u] != Integer.MAX_VALUE &&
                        dist[u] + g[u][v] < dist[v])
                        dist[v] = dist[u] + g[u][v];

        for (int u = 0; u < N; u++)
            for (int v = 0; v < N; v++)
                if (g[u][v] != 0 && dist[u] != Integer.MAX_VALUE &&
                    dist[u] + g[u][v] < dist[v]) {
                    System.out.println("Negative weight cycle detected.");
                    return;
                }

        System.out.println("Vertex \t Distance from Source");
        for (int i = 0; i < N; i++)
            System.out.println((i + 1) + "\t\t" + dist[i]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of Vertices : ");
        N = sc.nextInt();

        g = new int[N][N];
        System.out.println("Enter the Weight Matrix of Graph");
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                g[i][j] = sc.nextInt();

        System.out.print("Enter the Source Vertex : ");
        bellmanFord(sc.nextInt() - 1);
    }
}

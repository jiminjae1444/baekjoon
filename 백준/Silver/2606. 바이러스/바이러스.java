import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Integer>[] virus;
    static int count=0;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        virus = new List[N+1];
        for (int i = 1; i <= N; i++) {
            virus[i] = new LinkedList<>();
        }
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            virus[u].add(v);
            virus[v].add(u);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(virus[i]);
        }
        visited = new boolean[N+1];
        dfs(1);
        System.out.println(count);
    }

    private static void dfs(int i) {
        visited[i] = true;
        for (int n : virus[i]) {
                if (!visited[n]) {
                    count++;
                    dfs(n);
                }
        }
    }
}
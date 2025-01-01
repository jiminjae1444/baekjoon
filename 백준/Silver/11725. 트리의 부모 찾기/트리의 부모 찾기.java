import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Integer>[] tree;
    static int [] parent;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        tree = new List[N+1];
        parent = new int[N+1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N-1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            tree[a].add(b);
            tree[b].add(a);
        }
        dfs(1);

        for (int i = 2; i <= N; i++) {
            System.out.println(parent[i]);
        }
    }

    private static void dfs(int i) {
        for (int j : tree[i]) {
            if (parent[j] == 0) {
                parent[j] = i;
                dfs(j);
            }
        }
    }
}
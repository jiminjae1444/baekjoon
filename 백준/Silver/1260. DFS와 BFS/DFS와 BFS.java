import java.util.*;

public class Main {
    static List<Integer>[] graph;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int V = sc.nextInt();

        graph = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i <= M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }
        boolean[] visited = new boolean[N + 1];
        boolean[] visited2 = new boolean[N + 1];
        List<Integer> path = new ArrayList<>();
        List<Integer> path2 = new ArrayList<>();
        dfs(V,visited,path,0,N);
        bfs(V,visited2,path2);
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + " ");
        }
        System.out.println();
        for (int i = 0; i < path2.size(); i++) {
            System.out.print(path2.get(i) + " ");
        }
    }

    private static void bfs(int v, boolean[] visited2, List<Integer> path2) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited2[v] = true;
        path2.add(v);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for(int node : graph[u]) {
                if(!visited2[node]) {
                    queue.add(node);
                    visited2[node] = true;
                    path2.add(node);
                }
            }
        }
    }

    private static void dfs(int v, boolean[] visited, List<Integer> dfsArr, int i, int n) {
        visited[v] = true;
        dfsArr.add(v);
        if (v>n){
            return;
        }
        for (int w : graph[v]) {
            if (!visited[w]) {
                dfs(w, visited, dfsArr, i++, n);
            }
        }
    }
}
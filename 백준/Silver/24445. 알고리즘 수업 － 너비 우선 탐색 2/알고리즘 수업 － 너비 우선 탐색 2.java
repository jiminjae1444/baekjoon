import java.util.*;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    static List<Integer>[] graph;
    static boolean[] visited;
    static int [] order;
    static int index=1;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int R = sc.nextInt();

        graph = new List[N + 1];
        for (int i = 1; i <=N ; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u].add(v);
            graph[v].add(u);
        }

        visited = new boolean[N + 1];
        order = new int[N + 1];
        for (int i = 1; i <= N ; i++) {
            Collections.sort(graph[i],Comparator.reverseOrder());
        }
        bfs(R);
        for (int i = 1; i <= N ; i++) {
            System.out.println(order[i]);
        }
    }

    private static void bfs(int r) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(r);
        visited[r] = true;
        order[r] = index++;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph[node]) {
                if (!visited[neighbor]) {
                    queue.add(neighbor);
                    visited[neighbor] = true;
                    order[neighbor] = index++;
                    queue.add(neighbor);
                }
            }
        }
    }
}
import java.util.*;

public class Main {
    static List<Integer>[] graph;
    static boolean[] visited;
    static int[] order;
    static int index = 1;  // 방문 순서

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 정점의 개수
        int M = sc.nextInt(); // 간선의 개수
        int R = sc.nextInt(); // 시작 정점

        // 그래프 초기화
        graph = new ArrayList[N + 1]; // 1번부터 N번까지 정점이 있다
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 입력
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u].add(v);  // u와 v가 연결됨
            graph[v].add(u);  // v와 u가 연결됨 (무방향)
        }

        // 각 정점의 인접 리스트를 오름차순으로 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        visited = new boolean[N + 1];  // 방문 여부 체크
        order = new int[N + 1];  // 각 정점의 방문 순서를 기록

        dfs(R);

        // 각 정점의 방문 순서를 출력
        for (int i = 1; i <= N; i++) {
            // 방문하지 않은 정점은 0으로 출력
            if (order[i] == 0) {
                System.out.println(0);
            } else {
                System.out.println(order[i]);
            }
        }
    }
    
    private static void dfs(int r) {
        visited[r] = true;  // 현재 노드 방문 처리
        order[r] = index++;  // 방문 순서를 기록

        // 인접 정점들 중 방문하지 않은 노드에 대해 DFS 호출
        for (int n : graph[r]) {
            if (!visited[n]) {
                dfs(n);
            }
        }
    }
}

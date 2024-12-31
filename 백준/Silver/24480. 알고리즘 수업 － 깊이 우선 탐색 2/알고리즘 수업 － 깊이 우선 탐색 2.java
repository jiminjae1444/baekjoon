import java.util.*;

public class Main {
    static List<Integer>[] graph;
    static boolean [] visited;
    static int [] order;
    static int index=1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int R = sc.nextInt();
        
        graph = new ArrayList[N+1];
        for(int i=1; i<=N;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<M;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u].add(v);
            graph[v].add(u);
        }
        
        for(int i=1;i<=N;i++){
            Collections.sort(graph[i],Comparator.reverseOrder());
        }
        
        visited = new boolean[N+1];
        order = new int[N+1];
        
        dfs(R);
        
        for(int i=1; i<=N; i++){
           System.out.println(order[i]);
        }
    }
    
    public static void dfs(int r){
        visited[r] = true;
        order[r] = index++;
       
        for(int n: graph[r]){
            if(!visited[n]){
                dfs(n);
            }
        }
    }
}
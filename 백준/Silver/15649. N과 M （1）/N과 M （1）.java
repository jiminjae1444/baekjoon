import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        boolean [] visited = new boolean[N+1];
        dfsBack(N,M,list,visited);
    }

    private static void dfsBack(int n, int m, List<Integer> list, boolean[] visited) {
        if (list.size()==m){
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <=n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list.add(i);
                dfsBack(n,m,list, visited);
                list.remove(list.size()-1);
                visited[i] = false;
            }
        }
    }
}
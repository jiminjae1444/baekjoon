import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int [] dx = {-1,1,0,0};
    static int [] dy = {0,0,-1,1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int M = sc.nextInt();
            int N = sc.nextInt();
            int K = sc.nextInt();
            int [][] arr = new int[N][M];
            boolean [][] visited = new boolean[N][M];
            for (int j = 0; j < K; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                arr[y][x] = 1;
            }
            int count = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (arr[j][k] == 1 && visited[j][k] == false) {
                        dfs(j,k,visited,M,N,arr);
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void dfs(int i, int j, boolean[][] visited, int m, int n, int[][] arr) {
        visited[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];

            if (nx<n && nx >=0 && ny <m && ny>=0 && !visited[nx][ny] && arr[nx][ny] == 1) {
                dfs(nx,ny,visited,m,n,arr);
            }
        }
    }
}
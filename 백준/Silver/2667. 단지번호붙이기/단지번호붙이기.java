import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int N;
    static int [][] map;
    static int [] dx ={-1,1,0,0};  // 상, 하, 좌, 우
    static int [] dy ={0,0,-1,1};  // 상, 하, 좌, 우
    static List<Integer> house = new ArrayList<Integer>();
    static boolean [][] visited;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        N = sc.nextInt();
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String str  = sc.next();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j]==1 && visited[i][j]==false) {
                    int houseCount = dfs(i,j);
                    house.add(houseCount);
                }
            }
        }
        house.sort(Integer::compareTo);
        sb.append(house.size()).append("\n");
        for (int i = 0; i < house.size(); i++) {
            sb.append(house.get(i)).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static int dfs(int i, int j) {
        visited[i][j] = true;
        int count = 1;

        // 상, 하, 좌, 우 네 방향으로 탐색
        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];

            // 유효한 범위 내에서, 집이 있고 방문하지 않은 곳이라면
            if (nx >=0 && ny >=0 && nx < N && ny < N && map[nx][ny] ==1 && !visited[nx][ny]) {
                count+=dfs(nx,ny);  //카운트에 1을 누적시키고 dfs함
            }
        }
        return count;
    }
}
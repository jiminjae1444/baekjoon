import java.util.*;
public class Main {
    static int dx[] ={-1,1,0,0};  //위 아래  상 하
    static int dy[] ={0,0,-1,1};    //오른쪽 왼쪽 좌 우
    public static void main(String[] args) {

   Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();  // 행의 개수
        int M= sc.nextInt();  // 열의 개수
        sc.nextLine();  // 다음 입력을 받기 전에 남은 줄바꿈 문자를 처리하기 위해 호출

        // 2차원 String 배열로 선언
        String[][] miro = new String[N][M];

        // 입력 받기
        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();  // 각 줄을 문자열로 입력받기
            for (int j = 0; j < M; j++) {
                miro[i][j] = String.valueOf(line.charAt(j));  // 각 문자를 String 배열에 저장
            }
        }
        boolean [][] visit = new boolean[N][M];
        int dist = bfsMiro(miro,visit,N,M);
        System.out.println(dist);
    }

    private static int bfsMiro(String[][] miro, boolean[][] visit, int n, int m) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0,1});
        visit[0][0] = true;
        while (!q.isEmpty()) {
            int [] cur = q.poll();
            int x =cur[0];
            int y = cur[1];
            int dist = cur[2];

            if (x==n-1 && y==m-1){
                return dist;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >=0 && ny >=0 && nx<n && ny<m && !visit[nx][ny] && miro[nx][ny].equals("1")) {
                    visit[nx][ny] = true;
                    q.add(new int[]{nx,ny,dist+1});
                }
            }
        }
        return -1;
    }
}
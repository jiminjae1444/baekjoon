import java.util.*;
class Solution {
    static int dx[] ={-1,1,0,0};  //위 아래  상 하
    static int dy[] ={0,0,-1,1};    //오른쪽 왼쪽 좌 우
    public int solution(int[][] maps) {
      boolean [][] already = new boolean[maps.length][maps[0].length];
      int a=bfsMap(maps,already);
      return a;
    }

    private static int bfsMap(int[][] maps, boolean[][] already) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1});
        already[0][0] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];

            if (x == maps.length - 1 && y == maps[0].length - 1) {
                return dist;
            }

            for (int k = 0; k < 4; k++) {
                int newX = x + dx[k];
                int newY = y + dy[k];
                if (newX >= 0 && newY >= 0 && newX <= maps.length-1 && newY <= maps[0].length-1 && !already[newX][newY] && maps[newX][newY] == 1) {
                    already[newX][newY] = true;
                    queue.offer(new int[]{newX, newY, dist + 1});
                }
            }
        }
        return -1;
    }
}
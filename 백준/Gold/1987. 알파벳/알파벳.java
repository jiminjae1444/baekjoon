import java.util.*;

public class Main {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();  // 행의 개수
        int C = sc.nextInt();  // 열의 개수
        sc.nextLine();  // 다음 입력을 받기 전에 남은 줄바꿈 문자를 처리하기 위해 호출

        // 2차원 String 배열로 선언
        String[][] matrix = new String[R][C];

        // 입력 받기
        for (int i = 0; i < R; i++) {
            String line = sc.nextLine();  // 각 줄을 문자열로 입력받기
            for (int j = 0; j < C; j++) {
                matrix[i][j] = String.valueOf(line.charAt(j));  // 각 문자를 String 배열에 저장
            }
        }
        boolean [][] visited = new boolean[R][C];
        Set<String> seen = new HashSet<>();
        int max = 0;
        max = dfsAlpa(matrix,0,0 , visited , seen, 0 , max);
        System.out.println(max);
    }

    private static int dfsAlpa(String[][] matrix, int i, int j, boolean[][] visited, Set<String> seen , int length, int max) {
        if(i>matrix.length-1 || j>matrix[0].length-1 || i<0 || j<0){
            return max;
        }
        if(visited[i][j] || seen.contains(matrix[i][j])){
            return max;
        }
        String cur = matrix[i][j];
        visited[i][j] = true;
        seen.add(cur);
        
        length++;
        
        max = Math.max(max,length);

        max = dfsAlpa(matrix, i+1, j, visited, seen, length, max);
        max = dfsAlpa(matrix, i-1, j, visited, seen, length, max);
        max = dfsAlpa(matrix, i, j-1, visited, seen, length, max);
        max = dfsAlpa(matrix, i, j+1, visited, seen, length, max);

        seen.remove(cur);
        visited[i][j] = false;
        return max;
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N][];

        for (int i = 0; i < N; i++) {
            dp[i] = new int[i+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i+1; j++) {
                dp[i][j] = Integer.parseInt(st.nextToken());
            }
        }
//        System.out.println(Arrays.deepToString(dp));

        int [][] max = new int[N][];
        for (int i = 0; i < N; i++) {
            max[i] = dp[i].clone();
        }
        
        for(int i=N-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                max[i][j] = Math.max(max[i+1][j], max[i+1][j+1]) + dp[i][j];
            }
        }
        System.out.println(max[0][0]);
    }
}

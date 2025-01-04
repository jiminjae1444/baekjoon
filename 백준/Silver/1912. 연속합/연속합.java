import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int [] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        // dp 배열 생성 (현재까지의 최대 부분합)
        int [] dp = new int[N];
        dp[0] = arr[0];

        int max = dp[0];  // 가장 큰 값 초기화

        for (int i = 1; i < N; i++) {
            dp[i] = Math.max(arr[i],dp[i - 1] + arr[i]); // dp[i-1]과 arr[i] 중 더 큰 값을 선택
            max = Math.max(max,dp[i]);  // 최대값 갱신
        }

        System.out.println(max);
        sc.close();
    }
}
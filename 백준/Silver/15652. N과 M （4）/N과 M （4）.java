import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int [] result = new int[M];
        dfsBackSort(N,M,result,0,1);
    }

    private static void dfsBackSort(int n, int m, int[] result, int dep, int start) {
        if (dep==m){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                sb.append(result[i]).append(" ");
            }
            String resultStr = sb.toString().trim();
            System.out.println(resultStr);
            return;
        }

        for (int i = start; i <= n; i++) {
            result[dep] =i;
            dfsBackSort(n,m,result, dep+1, i);
        }
    }
}
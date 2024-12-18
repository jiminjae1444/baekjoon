import java.util.*;
public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int [] result = new int[M];
        dfsBackList(N,M,result,0);
        System.out.println(sb.toString());
    }

    private static void dfsBackList(int n, int m, int[] result,int length) {
        if (length==m){
            for (int i = 0; i < length; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n"); 
            return;
        }
        for (int i = 1; i <= n; i++) {
            result[length] = i;
            dfsBackList(n,m,result,length+1);
        }
    }
}
import java.util.*;
public class Main {
    public static void main(String[] args) {  
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int [] result = new int[M];
        dfsBackDistinct(0,M,N,result,1);
    }

    private static void dfsBackDistinct(int first, int m , int n, int[] result, int start){
        if(first==m){
            for (int i = 0; i < m; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i <= n; i++) {
            result[first] = i;
            dfsBackDistinct(first+1,m,n,result, i+1);
        }
    }
}

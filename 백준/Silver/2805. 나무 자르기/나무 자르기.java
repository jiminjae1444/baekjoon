import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        int maxHeight=0;
        int [] tree = new int[N];
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            tree[i] = x;
            maxHeight = Math.max(maxHeight, x);
        }
        int left = 0;
        int right = maxHeight;
        int result = 0;
        while (left <= right) {
            int mid = (left + right) / 2;

            long totalHeight = 0;
            for (int t : tree){
                if (t > mid){
                    totalHeight += t - mid;
                }
            }
            if (totalHeight >= M){
                result = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        sb.append(result).append("\n");
        System.out.println(sb);
    }
}
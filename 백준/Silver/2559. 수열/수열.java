import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        int K = sc.nextInt();
        int [] temper = new int[N];
        for (int i = 0; i < N; i++) {
            temper[i] = sc.nextInt();
        }
        int currentSum = 0;
        for (int i = 0; i < K; i++) {
            currentSum += temper[i];
        }

        int max=currentSum;
        for (int i = K; i < N; i++) {
            currentSum = currentSum - temper[i-K] + temper[i];
            max=Math.max(max,currentSum);
        }
        sb.append(max);
        System.out.println(sb.toString());
    }
}
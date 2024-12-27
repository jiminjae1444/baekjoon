import java.util.*;

public class Main {

    public static void main(String[] args){
       Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        PriorityQueue <Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int n = sc.nextInt();
            if (n == 0) {
                if (pq.isEmpty()) {
                    sb.append('0').append('\n');
                } else {
                    sb.append(pq.poll()).append('\n');
                }
            } else {
                pq.add(n);
            }
        }
        System.out.println(sb.toString());
    }
}
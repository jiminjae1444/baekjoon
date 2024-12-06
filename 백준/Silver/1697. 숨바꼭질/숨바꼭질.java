import java.util.*;
public class Main {    
 public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int second = bfsSec(N,K);
        System.out.println(second);
        sc.close();
    }

    private static int bfsSec(int n, int k) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        visited.add(n);

        int sec = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                if (cur == k) {
                    return sec;
                }

                int next = cur-1;
                if (!visited.contains(next) && next>=0 ) {
                    visited.add(next);
                    queue.add(next);
                }
                int next2 = cur +1;
                if (!visited.contains(next2) && next2<=100000 ) {
                    visited.add(next2);
                    queue.add(next2);
                }
                int next3 = cur*2;
                if (!visited.contains(next3) && next3<=100000 ) {
                    visited.add(next3);
                    queue.add(next3);
                }
            }
            sec++;
        }
        return -1;
    }
}
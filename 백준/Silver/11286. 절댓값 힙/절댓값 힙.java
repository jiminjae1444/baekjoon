import java.util.*;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
            int  comp = Math.abs(a) - Math.abs(b);
            if (comp==0){
                return a-b;
            }
            return comp;
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            if (x==0 && !pq.isEmpty()) {
                sb.append(pq.poll()).append("\n");
            } else if (x==0 && pq.isEmpty()) {
                sb.append("0").append("\n");
            }else{
                pq.add(x);
            }
        }
        System.out.println(sb.toString());
    }
}
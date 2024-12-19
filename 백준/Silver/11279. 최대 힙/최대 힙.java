import java.util.*;

public class Main {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        for (int i = 1; i <= X; i++) {
            int a = sc.nextInt();
            if(a>0){
                pq.add(a);
            } else {
                if (pq.isEmpty()){
                    System.out.println(0);
                }else{
                    System.out.println(pq.poll());
                }
            }
        }
    }
}
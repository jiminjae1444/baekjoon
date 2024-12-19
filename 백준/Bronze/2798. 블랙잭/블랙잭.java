import java.util.*;
public class Main {
    static int max = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);  
        int N = sc.nextInt();
        int M = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(sc.nextInt());
        }

        blackJack(list, M, 0, 0, 0); 
        System.out.println(max); 
    }


    private static void blackJack(List<Integer> list, int m, int sum, int count, int start) {
        if (count == 3) {
            if (sum <= m) {
                max = Math.max(max, sum);  
            }
            return;
        }

        for (int i = start; i < list.size(); i++) {
            blackJack(list, m, sum + list.get(i), count + 1, i + 1); 
        }
    }
}
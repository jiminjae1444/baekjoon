import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }
        dequeRemove(deque);
    }

    private static void dequeRemove(Deque<Integer> deque) {
        while (deque.size() > 1) {
            deque.pop();
            int num =deque.peek();
            deque.addLast(num);
            deque.pop();
        }
        System.out.println(deque.getFirst());
    }
}
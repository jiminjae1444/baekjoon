import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayDeque<Integer> deck = new ArrayDeque<>();
        int N = sc.nextInt();
        sc.nextLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String num = sc.nextLine();
            String num1 = num.split(" ")[0];
            if (num1.equals("6")) {
                if (deck.isEmpty()) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            } else if (num1.equals("1")) {
                String num2 = num.split(" ")[1];
                deck.addFirst(Integer.valueOf(num2));
            } else if (num1.equals("2")) {
                String num2 = num.split(" ")[1];
                deck.addLast(Integer.valueOf(num2));
            } else if (num1.equals("3")) {
                if (!deck.isEmpty()) {
                    sb.append(deck.pollFirst()).append("\n");
                } else {
                    sb.append(-1).append("\n");
                }
            } else if (num1.equals("4")) {
                if (!deck.isEmpty()) {
                    sb.append(deck.pollLast()).append("\n");
                } else {
                    sb.append(-1).append("\n");
                }
            } else if (num1.equals("5")) {
                sb.append(deck.size()).append("\n");
            } else if (num1.equals("7")) {
                if (!deck.isEmpty()) {
                    sb.append(deck.peekFirst()).append("\n");
                } else {
                    sb.append(-1).append("\n");
                }
            } else if (num1.equals("8")) {
                if (!deck.isEmpty()) {
                    sb.append(deck.peekLast()).append("\n");
                } else {
                    sb.append(-1).append("\n");
                }
            }
        }
            System.out.println(sb.toString());
        }
}
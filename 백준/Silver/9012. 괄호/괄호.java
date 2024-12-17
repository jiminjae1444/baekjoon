import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Stack<String> stack = new Stack<>();
        List<String> list = new ArrayList<>();
        sc.nextLine();
        for (int i = 0; i < N; i++) {
            String s = sc.nextLine();
            list.add(s);
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(pushStack(list.get(i),stack).size()==0 ? "YES" : "NO");
        }
    }

    private static Stack<String> pushStack(String s, Stack<String> stack) {
        stack.clear();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                    stack.push(String.valueOf(s.charAt(i)));
            } else if (stack.peek().equals("(") && s.charAt(i) == ')') {
                stack.pop();
            }else{
                stack.push(String.valueOf(s.charAt(i)));
            }
        }
        return stack;
    }
}

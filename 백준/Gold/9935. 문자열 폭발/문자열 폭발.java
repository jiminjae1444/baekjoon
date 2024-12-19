import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         String str = sc.nextLine();
        String exp = sc.nextLine();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            stack.push(ch);

            if (stack.size() >= exp.length()) {
                boolean same = true;
                for (int j = 0; j < exp.length(); j++) {
                    if (stack.get(stack.size() - exp.length() + j) != exp.charAt(j)) {
                        same = false;
                        break;
                    }
                }
                if (same) {
                    for (int j = 0; j < exp.length(); j++) {
                        stack.pop();
                    }
                }
            }
        }
            if(stack.isEmpty()){
                System.out.println("FRULA");
            }
            StringBuilder sb = new StringBuilder();
            for(char c: stack){
                sb.append(c);
            }
            System.out.println(sb.toString());
        }
}
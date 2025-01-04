import java.util.Scanner;

public class Main {
    static int count=1;
    static int flag=1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            String s = sc.next();
            flag=1;
            count=1;
            recursion(s,0,s.length()-1);
            sb.append(flag).append(" ").append(count).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void recursion(String s, int i, int j) {
        if (i>=j){
            return;
        }
        char c = s.charAt(i);
         char c2 = s.charAt(j);
        if (c==c2){
            count++;
            recursion(s,i+1, j-1);
        }else{
            flag = 0;
            return;
        }
    }
}
import java.util.*;
public class Main {
    public static void main(String[] args) {
        
     Scanner sc = new Scanner(System.in);
     int N = sc.nextInt();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String s = sc.next();
            set.add(s);
        }

        set.stream().sorted((a,b)->{
            int compare = a.length()-b.length();
            if (compare == 0){
                return a.compareTo(b);
            }
            return compare;
        }).forEach(System.out::println);
        sc.close();
    }
}
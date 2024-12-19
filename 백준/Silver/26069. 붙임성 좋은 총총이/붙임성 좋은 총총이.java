import java.util.*;
public class Main {
    static Set<String> set = new HashSet<>();
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();
            sc.nextLine();
            List<String> list = new ArrayList<>();
            for (int i = 1; i <= N; i++) {
                String str = sc.nextLine();
                list.add(str);
            }
            set.add("ChongChong");
            for (int i = 0; i < list.size(); i++) {
                String one = list.get(i).split(" ")[0];
                String two = list.get(i).split(" ")[1];
                if(set.contains(one) || set.contains(two)) {
                    set.add(one);
                    set.add(two);
                }
            }
        System.out.println(set.size());
    }
}
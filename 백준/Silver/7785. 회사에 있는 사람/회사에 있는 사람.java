import java.util.*;
public class Main {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int n = sc.nextInt();
         sc.nextLine();
         HashMap<String, String> map = new HashMap<>();
         List<String> list = new ArrayList<>();
         for (int i = 0; i < n; i++) {
             String key = sc.nextLine();
             map.put(key.split(" ")[0], key.split(" ")[1]);
         }
         for (Map.Entry<String, String> entry : map.entrySet()) {
             if(entry.getValue().equals("enter")){
                 list.add(entry.getKey());
             }
         }
         list.sort((a,b)->b.compareTo(a));
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
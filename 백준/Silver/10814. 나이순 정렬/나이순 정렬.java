import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<String>();
        int N = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < N; i++) {
            String ageAndName = sc.nextLine();
            list.add(ageAndName);
        }
        list.sort((a,b)->{
            int age = Integer.parseInt(a.split(" ")[0]);
            int age2 = Integer.parseInt(b.split(" ")[0]);
            if (age == age2) {
                return 0;
            }
            return age - age2;
        });
        for (String s : list) {
            sb.append(s).append("\n");
        }
        System.out.println(sb.toString());
    }
}
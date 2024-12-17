import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < N; i++) {
            String a = sc.nextLine();
            list.add(a);
        }
        list.sort((a,b)-> {
            int compare1 = listCompare(a) - listCompare(b);

            if (compare1 == 0) {
                return listCompare2(a) - listCompare2(b);
            }
            return compare1;
        });
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        sc.close();
    }

    private static int listCompare2(String a) {
        return Integer.parseInt(a.split(" ")[1]);
    }

    private static int listCompare(String a) {
        return Integer.parseInt(a.split(" ")[0]);
    }
}
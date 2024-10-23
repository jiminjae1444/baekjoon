import java.util.*;

public class Main {        
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String word =sc.nextLine();
        String [] spl = word.strip().split(" ");
        int length = spl.length;
        if (length == 1 && spl[0].isEmpty()) {
            length = 0;
        }
        System.out.println(length);
        sc.close();
    }
}
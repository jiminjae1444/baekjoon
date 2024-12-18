import java.util.*;
public class Main {
    public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     int N = sc.nextInt();
        int num = 666;
        int i=0;
        while (true) {
            if(String.valueOf(num).contains("666")){
                i++;
            }
            if (i==N){
                System.out.println(num);
                break;
            }
            num++;

        }
    }
}
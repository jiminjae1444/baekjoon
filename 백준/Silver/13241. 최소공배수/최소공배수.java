import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextInt();
        long B = sc.nextInt();

        System.out.println(LCM(A,B));
    }

    private static long GCD(long a, long b) {
        if (b==0){
            return a;
        }else{
            return GCD(b,a%b);
        }
    }
    private static long LCM(long a, long b) {
        return (a*b) / GCD(a,b);
    }
}
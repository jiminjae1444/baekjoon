import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        for (int i = 0; i < n; i++) {
             long num = sc.nextLong();
            System.out.println(isPrimeMin(num));
        }
    }

    private static long isPrimeMin(long num) {
        while(true){
            if(isPrime(num)){
                return num;
            }
            num++;
        }
    }
     public static boolean isPrime (long n){
        if (n<=1){
            return false;
        }
        for (long i = 2; i <=Math.sqrt(n); i++){
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }
}
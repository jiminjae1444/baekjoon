import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N =sc.nextInt();
        int[] arr = new int[N];
        int [] sumarr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        sumarr[0] = arr[0];
        int sum=arr[0];
        for (int i = 1; i < N; i++) {
            sumarr[i] = sumarr[i-1]+arr[i];
            sum+=sumarr[i];
        }
        System.out.println(sum);
    }
}
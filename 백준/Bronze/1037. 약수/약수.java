import java.util.*;

public class Main {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        int [] num = new int[N];
        for (int i = 0; i < N; i++) {
            num[i] = sc.nextInt();
        }
        Arrays.sort(num);
        if (N==1){
            sb.append(num[0] * num[0]);
        }else{
            sb.append(num[0]*num[N-1]);
        }
        System.out.println(sb.toString());
    }
}
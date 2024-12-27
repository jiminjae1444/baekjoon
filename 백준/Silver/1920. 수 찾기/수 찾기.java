import java.util.*;

public class Main {

    public static void main(String[] args) {  
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        int [] arr = new int[N];
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            arr[i] = x;
        }
        Arrays.sort(arr);
        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            int x = sc.nextInt();
            if (binarySearch(arr,x )==-1){
                sb.append("0").append("\n");
            }else{
                sb.append("1").append("\n");
            }
        }
        System.out.println(sb.toString());
    }
       private static int binarySearch(int[] arr, int n) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if(arr[mid] == n) {
                return mid;
            }else if(arr[mid] < n) {
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
import java.util.*;

public class Main {
  public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        int [] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int left = 1;  //최소 간격
        int right = arr[N-1] - arr[0]; //가장 먼집 간격
        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            if(successInstall(arr,M,N,mid)){
                result = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        sb.append(result);
        System.out.println(sb.toString());
    }
private static boolean successInstall(int[] arr, int m, int n, int mid) {
        int lastDist = arr[0]; // 첫번째 집 위치
        int count = 1;  //첫번째는 무조건 설치이므로
        for (int i = 1; i < n; i++) {
            if(arr[i] -lastDist>=mid){
                count++;
                lastDist = arr[i];  //lastDist 갱신
            }
            if (count>=m){  //개수
                return true;
            }
        }
        return false;
    }
}
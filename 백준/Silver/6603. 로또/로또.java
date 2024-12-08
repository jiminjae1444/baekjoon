import java.util.*;

public class Main {
    static int[] arr = new int[6]; 
    static int[] nums = new int[13]; 
    static int n;

    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

        while (true) {
            n = sc.nextInt();
            if (n == 0) break;

            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }

          
            dfs(0, 0);
            System.out.println(); 
        }

        sc.close(); 
    }
    private static void dfs(int start, int count) {
        if (count == 6) { 
            for (int i = 0; i < 6; i++) {
                System.out.print(arr[i] + " "); 
            }
            System.out.println();  
            return;
        }

        for (int i = start; i < n; i++) {
            arr[count] = nums[i]; 
            dfs(i + 1, count + 1); 
        }
    }
}

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();
        String [] nums = num.split(" ");
        System.out.println(reverse(nums[0]) > reverse(nums[1]) ? reverse(nums[0]) : reverse(nums[1]));
    }
    public static int reverse(String x) {
        String str="";
        for (int i = x.length() - 1; i >= 0; i--) {
            str+=x.charAt(i);
        }
        return Integer.parseInt(str);
    }
}
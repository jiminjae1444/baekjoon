import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] words = input.split("-");
        String [] first = words[0].split("\\+");
        int result = 0;
        for (String word : first){
            result += Integer.parseInt(word);
        }
        for (int i = 1; i < words.length; i++) {
            String [] plus = words[i].split("\\+");
            int sum = 0;
            for (String word : plus){
                sum+=Integer.parseInt(word);
            }
            result -= sum;
        }
        System.out.println(result);
        }
    }
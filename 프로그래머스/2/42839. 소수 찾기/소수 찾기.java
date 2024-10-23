import java.util.*;
class Solution {
    public int solution(String numbers) {
        int count=0;
        makeNumbers("",numbers);
        // System.out.println(set);
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            int number= iterator.next();
                if (isPrime(number)){
                    count++;
                }
        }
        return count;

    }

    private static boolean isPrime(int num) {
        if (num ==1 || num==0){
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    static HashSet<Integer> set = new HashSet<>();
    public static void makeNumbers(String s, String others) {
        if (!s.isEmpty()) {
            set.add(Integer.parseInt(s));
        }
        for (int i = 0; i < others.length(); i++) {
            makeNumbers(s + others.charAt(i), others.substring(0,i) + others.substring(i + 1));
        }
    }
}
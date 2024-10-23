import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer="";
        Comparator <String> comparator =new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.valueOf(o2+o1)-Integer.valueOf(o1+o2);
            }
        };
        String [] numberString = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            numberString[i]=numbers[i]+"";
        }
        Arrays.sort(numberString,comparator);
        for (String num1:numberString) {
            answer+=num1;
        }
        if(answer.startsWith("0")){
            answer="0";
        }
        return answer;
    }
}
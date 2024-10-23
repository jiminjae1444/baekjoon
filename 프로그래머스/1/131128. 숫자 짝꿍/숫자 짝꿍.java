import java.util.*;
class Solution {
    public String solution(String X, String Y) {
        String answer="";    
        StringBuilder stringBuilder = new StringBuilder();

        int [] xArr=new int[10];
        int [] yArr=new int[10];

        for (String x:X.split("")) {
            xArr[Integer.parseInt(x)]++;
        }

        for (String y:Y.split("")) {
            yArr[Integer.parseInt(y)]++;
        }

        for (int i = 9; i >=0; i--) {
            while (xArr[i] > 0 && yArr[i] > 0) {
                stringBuilder.append(i);
                xArr[i]--;
                yArr[i]--;
            }
        }
         answer = stringBuilder.toString();

        if (answer.isEmpty()) {
            answer= "-1";
        }

        if (answer.startsWith("0")) {
            answer="0";
        }

        return answer;
    }
}

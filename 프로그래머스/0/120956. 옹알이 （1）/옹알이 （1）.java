import java.util.*;
class Solution {
    public int solution(String[] babbling) {
              String babbling1 ="aya";
        String babbling2 ="ma";
        String babbling3 ="woo";
        String babbling4 ="ye";

        int count=0;
        for (int i = 0; i < babbling.length; i++) {
            babbling[i]=babbling[i].replace(babbling1,"1");
            babbling[i]=babbling[i].replace(babbling2,"2");
            babbling[i]=babbling[i].replace(babbling3,"3");
            babbling[i]=babbling[i].replace(babbling4,"4");
            if (babbling[i].matches("^[1-4]*$")){
                if (stack(babbling[i])){
                    count++;
                }
            }
        }
        return count;
    }
    public static boolean stack(String a){
        boolean flag=true;
        Stack <String> stack = new Stack<>();
        for (int i = 0; i < a.length(); i++) {
            String ch = String.valueOf(a.charAt(i));

            if (stack.isEmpty()){
                stack.push(ch);
            } else if (stack.peek().equals(ch)) {
                    flag=false;
                    return flag;
            }else{
                stack.push(ch);
            }
        }
        return flag;
    }
}
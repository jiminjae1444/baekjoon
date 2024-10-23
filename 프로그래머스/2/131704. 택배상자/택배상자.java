import java.util.*;
class Solution {
    public int solution(int[] order) {
        int count=countBox(order);   
        return count;
    }
        public static int countBox(int[] order){
        int index=0;
        int count=0;
        Stack <Integer> stack = new Stack<>();
        for (int i=1;i<=order.length;i++){
            if (order[index] == i){
                index++;
                count++;
            }else{
                stack.push(i);
            }
            while (!stack.isEmpty() && stack.peek() == order[index]){
                stack.pop();
                index++;
                count++;
            }
        }

        return count;
    }
}
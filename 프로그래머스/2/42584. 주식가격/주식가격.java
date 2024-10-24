import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
         // int [] prices = {1,2,3,2,3};
        int [] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
            answer[i] = -1;
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int idx = stack.pop();
                answer[idx] = i - idx;
            }
            stack.push(i);
        }
        for (int i : stack){
            answer[i] = prices.length - i -1;
        }
        return answer;
    }
}
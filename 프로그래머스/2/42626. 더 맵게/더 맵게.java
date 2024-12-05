import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : scoville) {
            pq.add(num);
        }
        int count=0;
        while (pq.size()>=2 && pq.peek() < K){
                int one = pq.poll();
                int two = pq.poll();
                int three = one + two*2;
                pq.add(three);
                count++;
        }
        count = pq.peek()>= K ? count : -1;
        return count;
    }
}
import java.util.*;
class Solution {
    public long solution(int n, int[] works) {

        long working = bfsWork(works,n);
        return working;
    }

    private static long bfsWork(int[] works, int n3) {
        int sum=0;
        for (int i = 0; i < works.length; i++) {
            sum += works[i];
        }
        if (sum<n3) {
            return 0;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int work : works) {
            maxHeap.add(work);
        }

        while (n3-- >0) {
            int cur = maxHeap.poll();
            if (cur > 0){
                maxHeap.add(cur - 1);
            }
        }
        long sumWork=0;
        while (!maxHeap.isEmpty()) {
            int work = maxHeap.poll();
            sumWork += work * work;
        }
        return sumWork;
    }
}
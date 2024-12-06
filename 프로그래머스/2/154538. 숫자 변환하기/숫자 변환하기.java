import java.util.*;
class Solution {
    public int solution(int x, int y, int n) {
         int a = bfsCount(x,y,n);
         return a;
    }

    private static int bfsCount(int x, int y, int n) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        visited.add(x);
        int bCount=0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();

                if (cur == y) {
                    return bCount;
                }

                int result = cur *3;
                if (!visited.contains(result) && cur < y) {
                    visited.add(result);
                    queue.add(result);
                }
                int result2 = cur * 2;
                if (!visited.contains(result2) && cur < y) {
                    visited.add(result2);
                    queue.add(result2);
                }
                int result3 = cur  + n;
                if (!visited.contains(result3) && cur < y) {
                    visited.add(result3);
                    queue.add(result3);
                }
            }
            bCount++;
        }
        return -1;
    }
}
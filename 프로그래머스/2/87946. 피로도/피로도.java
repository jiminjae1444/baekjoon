import java.util.*;
class Solution {
    public int solution(int k, int[][] dungeons) {
        boolean [] clear = new boolean[dungeons.length];
        int cc = dfsDungeons(dungeons,k,0,clear);
        return cc;

    }

    private static int dfsDungeons(int[][] dungeons, int k, int count, boolean[] clear) {
        if (count==dungeons.length ) {
            return count;
        }
        int max = count ;
        for (int j = 0; j < dungeons.length; j++) {
            if (k>=dungeons[j][0] && !clear[j]) {
                clear[j] = true;
                int nCount = dfsDungeons(dungeons,k-dungeons[j][1],count+1,clear);
                max= Math.max(max,nCount);
                clear[j] = false;
            }
        }
        return max;
    }
}
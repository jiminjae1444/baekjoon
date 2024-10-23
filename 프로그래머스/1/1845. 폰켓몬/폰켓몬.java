import java.util.*;
class Solution {
    public int solution(int[] nums) {
     int answer=0;
        int n = nums.length/2;
        HashSet<Integer> hashSet = new HashSet<>(n);
        for (int num :nums) {
            hashSet.add(num);
        }
        if (hashSet.size()>n){
            answer=n;
        }else{
            answer=hashSet.size();
        }
        return answer;
    }
}
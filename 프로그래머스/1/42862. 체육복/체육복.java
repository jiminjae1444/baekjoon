import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        HashSet<Integer> hasSet = new HashSet<>();
        HashSet<Integer> hasSet2 = new HashSet<>();
        HashSet<Integer> lostSet = new HashSet<>();
        for (int num : reserve){
            hasSet.add(num);
            hasSet2.add(num);
        }
        for (int lostN : lost){
            lostSet.add(lostN);
        }
        System.out.println(lostSet);
        hasSet2.retainAll(lostSet);
        Iterator<Integer> iterator2 = hasSet2.iterator();
        while (iterator2.hasNext()){
            int number= iterator2.next();
            hasSet.remove(number);
            lostSet.remove(number);
        }
        System.out.println(hasSet);
        Iterator<Integer> integerIterator = hasSet.iterator();
        while (integerIterator.hasNext()){
            int number = integerIterator.next();
            if ((lostSet.contains(number-1))) {
                lostSet.remove(number - 1);
            } else if(lostSet.contains(number+1)){
                lostSet.remove(number+1);
            }
        }
        return n - lostSet.size();
    }
}
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String[] operations) {
         PriorityQueue<Integer> pq2 = new PriorityQueue<>();
        // String [] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        List<Integer> toList = new ArrayList<>();
        for (String operation : operations) {
            if (operation.split(" ")[0].equals("I")) {
                pq2.add(Integer.valueOf(operation.split(" ")[1]));
            }
            else if (operation.split(" ")[0].equals("D")) {
                if (operation.split(" ")[1].equals("-1")) {
                    if (!pq2.isEmpty()){
                        pq2.poll();
                    }
                }else{
                    if (!pq2.isEmpty()) {
                        List<Integer> maxList = pq2.stream().collect(Collectors.toList());
                        Collections.sort(maxList);
                        int max = maxList.get(maxList.size()-1);
                        pq2.remove(max);
                    }
                }
            }
        }
        if (pq2.isEmpty()){
            toList.add(0);
            toList.add(0);
            return toList.stream().mapToInt(i->i).toArray();
        }else{
            List<Integer> maxList2 = pq2.stream().collect(Collectors.toList());
            Collections.sort(maxList2);
            int max2 = maxList2.get(maxList2.size()-1);
            toList.add(max2);
            toList.add(pq2.peek());
            return toList.stream().mapToInt(i->i).toArray();
        }
    }
}
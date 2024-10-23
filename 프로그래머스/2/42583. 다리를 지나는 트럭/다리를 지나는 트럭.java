import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        //int birdge_length = 2;
        //int weight = 10;
        int time =0;
        int bridge = 0 ;
        //int []  truck_weights = {7,4,5,6};
        Queue <Integer> truck_weights2 = new LinkedList<>();
        Queue <Integer> bridge_wieght = new LinkedList<>();
        for (int i = 0; i < truck_weights.length; i++) {
            truck_weights2.add(truck_weights[i]);
        }
        for (int i = 0; i < bridge_length; i++) {
            bridge_wieght.add(0);
        }
        while (bridge_wieght.size() != 0) {
           int left = bridge_wieght.poll();
           bridge -= left;
           time+=1;
           if (!truck_weights2.isEmpty()) {
               if (truck_weights2.peek() + bridge <= weight) {
                   int truck_weight = truck_weights2.poll();
                   bridge += truck_weight;
                   bridge_wieght.add(truck_weight);
               } else {
                   bridge_wieght.add(0);
               }
           }
        }
        return time;
    }
}
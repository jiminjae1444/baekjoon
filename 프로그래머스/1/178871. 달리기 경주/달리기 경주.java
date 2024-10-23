import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
         Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            map.put(players[i],i);
        }
        for (String calls:callings) {
            int currentIndex = map.get(calls);
            if (map.get(calls)>0){
                String tmp = players[currentIndex];
                players[currentIndex] = players[currentIndex-1];
                players[currentIndex-1] = tmp;

                map.put(players[currentIndex],currentIndex);
                map.put(players[currentIndex-1],currentIndex-1);
            }
        }
        return players;
    }
}

import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        //      String [] keymap = {"AGZ", "BSSS"};
        // String [] target = {"ASA","BGZ"};
        int sum=0;
        Map<Character,Integer > oneKeyMap = new HashMap<>();
        List<Integer> numList = new ArrayList<>();
//        Map<Character,Integer > twoKeyMap = new HashMap<>();
        for (int i = 0; i < keymap.length; i++) {
            for (int j = 0; j < keymap[i].length(); j++) {
                char ch = keymap[i].charAt(j);
                // System.out.println(ch);
                if (!oneKeyMap.containsKey(ch) || oneKeyMap.get(ch) > j + 1) {
                    oneKeyMap.put(ch, j + 1);
                }
                // System.out.println(oneKeyMap);
            }
        }
        for (String key : targets){
            key.toCharArray();
            for (char c : key.toCharArray()) {
                if (oneKeyMap.containsKey(c)) {
                    sum+=oneKeyMap.get(c);
                }else{
                    sum=-1;
                    break;
                }
            }
            numList.add(sum);
            sum=0;
        }
        return numList.stream().mapToInt(i->i).toArray();
    }
}
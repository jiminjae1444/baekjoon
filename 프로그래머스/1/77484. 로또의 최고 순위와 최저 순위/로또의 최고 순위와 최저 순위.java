import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int count = 0;
        int count2 = 0;
        int[] answer = new int[2];
        
        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] == 0) {
                count++;
            }   
        }
        List<Integer> lList = new ArrayList<>();
        for (int num : lottos) {
            lList.add(num);
        }
        List<Integer> wList = new ArrayList<>();
        for (int num : win_nums) {
            wList.add(num);
        }
        wList.retainAll(lList);
        count2 = wList.size();
        
        answer[1] = rank(count2);
        answer[0] = rank(count2 + count);
        return answer;
    }
    
    public int rank(int num){
        int rank = 0;
        if(num <= 1){
            rank = 6;
        } else if(num == 2){
            rank = 5;
        } else if(num == 3){
            rank = 4;
        } else if(num == 4){
            rank = 3;
        } else if(num == 5){
            rank = 2;
        } else{
            rank = 1;
        }
        return rank;
    }
}

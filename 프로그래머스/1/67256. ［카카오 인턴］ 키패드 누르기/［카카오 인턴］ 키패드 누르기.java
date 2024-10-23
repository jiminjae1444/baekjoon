import java.util.*;
class Solution {
        Position left;
        Position right;
        Position numPosition;
    public String solution(int[] numbers, String hand) {
        String answer = "";
        left = new Position(3,0);
        right = new Position(3,2);
        for (int num : numbers) {
            numPosition = new Position((num-1)/3,(num-1)%3);
            if (num==0){
                numPosition = new Position(3,1);
            }
            String finger = numPosition.getFinger(hand);
            answer+=finger;
            if (finger.equals("L")){
                left=numPosition;
            }else{
                right=numPosition;
            }
        }

        return answer;
    }
    class Position{
        int row;
        int col;

        Position(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public String getFinger(String hand) {
            String finger = hand.equals("right") ? "R" : "L";
            if (this.col==0){
                finger ="L";
            } else if (this.col == 2) {
                finger ="R";
            }else{
                int leftDist = left.getDistance(this);
                int rightDist = right.getDistance(this);

                if (leftDist<rightDist){
                    finger="L";
                } else if (rightDist<leftDist) {
                    finger="R";
                }
            }
            return finger;
        }

        private int getDistance(Position position) {
            return Math.abs(this.row -position.row)+Math.abs(this.col-position.col);
        }
    }
}

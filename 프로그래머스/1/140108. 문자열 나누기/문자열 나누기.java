class Solution {
    public int solution(String s) {
        char prech = s.charAt(0);
        int compareCount=1;
        int count8=0;
        for (int i = 1; i <s.length() ; i++) {
                char c = s.charAt(i);
                if (compareCount==0){
                    prech = c;
                    compareCount++;
                    continue;
                }
                if (prech ==c){
                    compareCount++;
                }else{
                    compareCount--;
                }
                if (compareCount==0){
                    count8++;
                }
        }
        if (compareCount != 0){
            count8++;
        }
        return count8;
        }
    }
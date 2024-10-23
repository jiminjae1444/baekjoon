import java.util.*;
class Solution {
    public int solution(String word) {
        List<String> list = new ArrayList<>();
        char [] vowels = {'A','E','I','O','U'};
        String word2 ="";
        int answer=0;
        wordMaker(word2,vowels,0,5,list);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(word)){
                answer=i+1;
                break;
            }
        }
        return answer;
    }
    public static void wordMaker(String word2, char[] vowels, int length, int maxLength, List<String> dict){
        if(length==maxLength){
            return;
        }else {
            for(char ch:vowels){
                String words = word2 + ch;
                dict.add(words);
                wordMaker(words,vowels,length+1,maxLength,dict);
            }
        }
    }
}
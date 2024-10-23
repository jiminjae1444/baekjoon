import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
       Map<String,Integer> map = new HashMap<>();
        List<String> surveyList = new ArrayList<>();
        // String [] survey = {"TR", "RT", "TR"};
        // int [] choice ={7,1,3};
        int T=0,C=0,A=0,N=0,R=0,F=0,M=0,J=0;
        for (String word : survey){
            surveyList.add(word);
        }
        String answer ="";
        for (int i = 0; i <surveyList.size() ; i++) {
            String firstword = surveyList.get(i).substring(0,1);
            String secondword =surveyList.get(i).substring(1);
            if (choices[i]==1){
                map.put(firstword,(map.getOrDefault(firstword,0)+3));
            }
            if (choices[i]==2){
                map.put(firstword,(map.getOrDefault(firstword,0)+2));
            }
            if (choices[i]==3){
                map.put(firstword,(map.getOrDefault(firstword,0)+1));
            }
            if (choices[i]==5){
                map.put(secondword,(map.getOrDefault(secondword,0)+1));
            }
            if (choices[i]==6){
                map.put(secondword,(map.getOrDefault(secondword,0)+2));
            }
            if (choices[i]==7){
                map.put(secondword,(map.getOrDefault(secondword,0)+3));
            }
        }
        for (String key : map.keySet()){
            if (key.equals("T")){
                T = map.get(key);
            }else if (key.equals("C")){
                C = map.get(key);
            }else if (key.equals("M")){
                M = map.get(key);
            }else if (key.equals("J")){
                J = map.get(key);
            }else if (key.equals("R")){
                R = map.get(key);
            }else if (key.equals("N")){
                N = map.get(key);
            }else if (key.equals("A")){
                A = map.get(key);
            }else if (key.equals("F")){
                F = map.get(key);
            }
        }
        if (R>=T){
            answer+="R";
        }else{
            answer+="T";
        }
        if (C >= F){
            answer+="C";
        }else{
            answer+="F";
        }
        if (J >= M){
            answer+="J";
        }else{
            answer+="M";
        }
        if (A>=N){
            answer+="A";
        }else {
            answer+="N";
        }
        return answer;
    }
}
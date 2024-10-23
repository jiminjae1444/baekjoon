import java.util.*;
class Solution {
    public int solution(String dartResult) {
        Stack<String> stack = new Stack<>();
        ArrayList<Integer> stackList = new ArrayList<>();
        String a = "1234567890";
        String num ="";
        int num2=0;
        for (char c : dartResult.toCharArray()) {
            if (a.contains(String.valueOf(c))) {
                num += c;
            }
            if (String.valueOf(c).equals("S") || String.valueOf(c).equals("D") || String.valueOf(c).equals("T")) {
                if (String.valueOf(c).equals("S")){
                    num2 = (int) Math.pow(Double.parseDouble(num),1);
                }
                if (String.valueOf(c).equals("D")){
                    num2 = (int) Math.pow(Double.parseDouble(num),2);
                }
                if (String.valueOf(c).equals("T")){
                    num2 = (int) Math.pow(Double.parseDouble(num),3);
                }
                stackList.add(num2);
                num = "";
            }
            if (String.valueOf(c).equals("#")|| String.valueOf(c).equals("*")) {
                if (String.valueOf(c).equals("*")) {
                    if (stackList.size()==2){
                        int num11 = stackList.get(0) * 2;
                        int num22 = stackList.get(1)*2;
                        stackList.remove(0);
                        stackList.add(0,num11);
                        stackList.remove(1);
                        stackList.add(1,num22);
                    }else if (stackList.size()==3){
                        int num11 = stackList.get(1) * 2;
                        int num22 = stackList.get(2)*2;
                        stackList.remove(1);
                        stackList.add(1,num11);
                        stackList.remove(2);
                        stackList.add(2,num22);
                    }else{
                        int num11 = stackList.get(0) * 2;
                        stackList.remove(0);
                        stackList.add(0,num11);
                    }
                }else{
                    if (stackList.size()==2){
                        int num11 =  stackList.get(1) * -1;
                        stackList.remove(1);
                        stackList.add(1,num11);
                    }else if (stackList.size()==3){
                        int num11 =  stackList.get(2) * -1;
                        stackList.remove(2);
                        stackList.add(2,num11);
                    }else{
                        int num11 =  stackList.get(0) * -1;
                        stackList.remove(0);
                        stackList.add(0,num11);
                    }
                }

            }
        }
        return stackList.get(0)+stackList.get(1)+stackList.get(2);
    }
}
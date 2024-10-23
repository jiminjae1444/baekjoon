class Solution {
    public String solution(String s, String skip, int index) {
       String answer="";
        // String s = "zzzzzzzz";
        // String skip = "abcdefghijklmnopqrstuvwxy";
        // int index = 6;
        char [] arr2 = s.toCharArray();
        for (int i = 0; i < arr2.length; i++) {
            answer+=reChar(arr2[i],index,skip);
        }
        return answer;
    }
    public static char reChar(char ch, int index, String skip) {
        int count = 0;
        while (count < index ) {
            ch++;
            if (ch > 'z') {
                ch = 'a';
            }
            if (!skip.contains(String.valueOf(ch))) {
                count++;
            }
        }
        return ch;
    }
}
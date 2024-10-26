import java.util.*;
class Solution {
    public String[] solution(String[] files) {
     List<String> fileList= new ArrayList<>();
        for (String file : files) {
            fileList.add(file);
        }
        String [] fileArray = fileList.toArray(new String[0]);
        // System.out.println(Arrays.toString(fileArray));
        Arrays.sort(fileArray, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int findIndex1 = findIdx(o1);
                int findIndex2 = findIdx(o2);

                String head1 = o1.substring(0, findIndex1).toLowerCase();
                String head2 = o2.substring(0, findIndex2).toLowerCase();

                // 헤드 비교
                int headCompare = head1.compareTo(head2);
                if (headCompare != 0) {
                    return headCompare;
                }else{
                    return numCompare(o1,head1) - numCompare(o2,head2);
                }
            }
        });
        return fileArray;
    }

    private static int numCompare(String o, String head) {
        String numb = "0123456789";
        int length = head.length();
        String number ="";
        int realLength = o.length() - length > 5 ? length + 5 : o.length();
        for (int i = length; i < realLength; i++) {
            char ch = o.charAt(i);
            if(numb.contains(String.valueOf(ch)) == true) {
                number += ch;
            } else{
                break;
            }
        }
     return Integer.parseInt(number);
    }
    private static int findIdx(String o1) {
        String numb = "0123456789";
        for (int i = 0; i < o1.length(); i++) {
            char ch = o1.charAt(i);
            if (numb.contains(String.valueOf(ch))) {
                return i;
            }
        }
        return 0;
    }
}
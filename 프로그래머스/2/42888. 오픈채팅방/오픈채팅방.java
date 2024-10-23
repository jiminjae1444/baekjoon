import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        Map<String,String> recordMap = new HashMap<>();
        List<String> recordList = new ArrayList<>();
        List<String> resultList = new ArrayList<>();
        for (String word : record){
            if (word.startsWith("E")){
                int index = word.indexOf(" ");
                int index2 = word.lastIndexOf(" ");
                String userid = word.substring(index,index2).trim();
                String nickname = word.substring(index2).trim();
                    recordMap.put(userid,nickname);
            }
            if (word.startsWith("C")){
                int index = word.indexOf(" ");
                int index2 = word.lastIndexOf(" ");
                String userid = word.substring(index,index2).trim();
                String nickname = word.substring(index2).trim();
                recordMap.put(userid,nickname);
            }
            recordList.add(word);
        }
        for (int i = 0; i < recordList.size(); i++) {
            int index = recordList.get(i).indexOf(" ");
            int index2 = recordList.get(i).lastIndexOf(" ");
            String userid = recordList.get(i).substring(index,index2).trim();
            // System.out.println(userid);
            if (recordList.get(i).startsWith("E")){
                if (recordMap.containsKey(userid)){
                    String nickname2 = recordMap.get(userid);
                    resultList.add(nickname2+"님이 들어왔습니다.");
                }
            }else if (recordList.get(i).startsWith("L")){
                int index3 = recordList.get(i).indexOf(" ");
                String userid2 = recordList.get(i).substring(index).trim();
                if (recordMap.containsKey(userid2)){
                    String nickname2 = recordMap.get(userid2);
                    resultList.add(nickname2 +"님이 나갔습니다.");
                }
            }
        }
        return resultList.stream().toArray(String[]::new);
    }
}
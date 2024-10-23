import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        //   String today ="2020.05.15";
        // String [] terms = {"A 1"};
        // String [] privacies = {"2001.01.10 A", "2001.01.10 A"};
        List<String> list = new ArrayList<>();
//        List<Integer> list2 = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        List<Integer> list2 = new ArrayList<>();
        List<String> list3 = new ArrayList<>();
        List<String> list5 = new ArrayList<>();
        for (int i = 0; i < terms.length; i++) {
            int index = terms[i].indexOf(" ");
            String key = terms[i].substring(0, index);
            int month = Integer.parseInt(terms[i].substring(index + 1));
            map.put(key,month);
        }
        // System.out.println(map);
        for (int i = 0; i < privacies.length; i++) {
            int index = privacies[i].indexOf(" ");
            String key = privacies[i].substring(0, index);
            String case2 = privacies[i].substring(index + 1);
            list3.add(key + " "+ case2);
        }
        // System.out.println(list3);
        for (String c : list3) {
            int index = c.indexOf(" ");
            String date = c.substring(0, index);
            String plus = c.substring(index + 1);
            int p = match(plus,map);
            // System.out.println(p);
            list5.add(String.valueOf(bigdate(today,month(date,p))));
            // System.out.println(list5);
        }
        for (int i = 0; i < list5.size(); i++) {
            if (list5.get(i).equals("true")){
                list2.add(i+1);
            }
        }
        return list2.stream().mapToInt(i->i).toArray();
    }
    private static int match(String word , Map<String, Integer> map) {
        if (map.containsKey(word)) {
            return map.get(word);
        }
        return 0;
    }
    private static boolean bigdate(String today , String cdate){
        boolean flag = false;
        int findex = today.indexOf(".");
        int lindex = today.lastIndexOf(".");
        int month = Integer.parseInt(today.substring(findex+1, lindex));
        int year = Integer.parseInt(today.substring(0,findex));
        int day = Integer.parseInt(today.substring(lindex+1));
        int month2 = Integer.parseInt(cdate.substring(findex+1, lindex));
        int year2 = Integer.parseInt(cdate.substring(0,findex));
        int day2 = Integer.parseInt(cdate.substring(lindex+1));
        if (year > year2){
            return true;
        }else if(year==year2 && month > month2){
            return true;
        } else if (year==year2 && month == month2 && day>day2) {
            return true;
        }
        return flag;
    }
    private static String month (String date, int plus) {
            int lindex = date.lastIndexOf(".");
            int findex = date.indexOf(".");
            int month = Integer.parseInt(date.substring(findex+1, lindex));
            int year = Integer.parseInt(date.substring(0,findex));
             if (plus > 12){
                year=year+(plus/12);
                month = month + plus%12;
            }else{
                month=month+plus;
            }
            if (month > 12){
                year = year+1;
                month = month%12 == 0 ?  12 :  month%12;
            }
            String month2="";
             int day = Integer.parseInt(date.substring(lindex+1));
            if (day>28){
                 day=28;
             }
            day = day-1;
            if (day==0){
                month=month-1;
                day=28;
            }
            String day2 ="";
            if (day<10){
                day2="0"+day;
            }else{
                day2=""+day;
            }
            if (month<10){
                month2="0"+month;
            }else{
                month2 = String.valueOf(month);
            }
            return year + "." + month2  + "." + day2;
    }
}
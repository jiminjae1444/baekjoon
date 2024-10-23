import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        //        int [] fees = {180, 5000, 10, 600};
        // String [] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        Map<String,Integer> map = new HashMap<>();
        Map<String,Integer> map2 = new HashMap<>();
        Map<String,Integer> map3 = new HashMap<>();
        Map<String,Integer> map4 = new HashMap<>();
        Map<String,Integer> map5 = new HashMap<>();
        Map<String,Integer> map6 = new HashMap<>();
        List<String> sortList = new ArrayList<>();
        List<Integer> feeList = new ArrayList<>();
        int regularTime = fees[0];
        int regularFee = fees[1];
        int perTime = fees[2];
        int perFee = fees[3];
        for (String r : records) {
            int spaceIndex = r.indexOf(" ");
            int spaceIndex2 = r.lastIndexOf(" ");
            int index2 = r.indexOf(":");
            String hourString = r.substring(0,index2);
            int hour = Integer.parseInt(hourString);
            String minString = r.substring(index2+1,spaceIndex);
            int min = Integer.parseInt(minString);
            String carNum = r.substring(spaceIndex+1,spaceIndex2);
            String inOrOut = r.substring(spaceIndex2);
            map.put(carNum,map.getOrDefault(carNum,0)+1);
            if (inOrOut.equals(" IN")){
                map2.put(carNum, map2.getOrDefault(carNum,0)-hour);
                map4.put(carNum, map4.getOrDefault(carNum,0)-min);
            }else if (inOrOut.equals(" OUT")) {
                map3.put(carNum, map3.getOrDefault(carNum,0)+hour);
                map5.put(carNum, map5.getOrDefault(carNum,0)+min);
            }
        }
        for (String c : map.keySet()) {
                if (map.get(c) % 2 ==1){
                    // System.out.println(c);
                    map3.put(c,map3.getOrDefault(c,0)+23);
                    map5.put(c,map5.getOrDefault(c,0)+59);
                }
        }
        for (String car : map3.keySet()) {
            int hh  = (map3.get(car)  + map2.get(car)) * 60;
            int mm = map4.get(car) + map5.get(car);
            int time = hh+mm;
            int upOrDown =0;
            if (time > regularTime) {
                 upOrDown = (time - regularTime) % perTime == 0 ? (time - regularTime) / perTime : (time - regularTime) / perTime + 1;
            }
            int totalFee = regularFee + upOrDown * perFee;
            map6.put(car,totalFee);
        }
        // System.out.println(map6);
        for (String car : map6.keySet()) {
            sortList.add(car);
        }
        sortList.sort(String::compareTo);
        for (int i = 0; i < sortList.size(); i++) {
            String carId = sortList.get(i);
            feeList.add(findValue(carId,map6));
        }
        return feeList.stream().mapToInt(i->i).toArray();
    }

    private static Integer findValue(String carId, Map<String, Integer> map6) {
        int value = 0 ;
        for (String car : map6.keySet()) {
            if (car == carId) {
                value = map6.get(car);
            }
        }
        return value;
    }
}
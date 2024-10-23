import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] arr = new int[id_list.length];
        Set<String> set = new HashSet<>();
        Map<String, ArrayList<String>> reportMap = new HashMap<>();
        Map<String, Integer> reportResult = new HashMap<>();
        List<String> stopList = new ArrayList<>();
        List<String> list = new ArrayList<>();
        for (String id : id_list) {
            reportResult.put(id, 0);
            list.add(id);
        }
        for (String rep : report) {
            set.add(rep);
        }
        for (String reporter : set) {
            int index = reporter.indexOf(" ");
            String reporterName = reporter.substring(0, index);
            String reportedName = reporter.substring(index + 1);
            ArrayList<String> reportList = reportMap.getOrDefault(reporterName, null);
            if (reportList == null) {
                reportList = new ArrayList<>();
            }
            reportList.add(reportedName);
            reportMap.put(reporterName, reportList);
        }
        // System.out.println(reportResult);
        for (List<String> reporter : reportMap.values()) {
            for (String reporterName : reporter) {
                if (reportResult.containsKey(reporterName)) {
                    reportResult.put(reporterName, reportResult.get(reporterName) + 1);
                }
            }
        }
        for (int i = 0; i < reportResult.entrySet().size(); i++) {
            if (reportResult.get(id_list[i]) >= k) {
                stopList.add(id_list[i]);
            }
        }
        // System.out.println(stopList);
        // System.out.println(reportMap);
//        "a", "ab", "abc", "b"
        for (String reporter : reportMap.keySet()) {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).equals(reporter)) {
                        reportMap.get(reporter).retainAll(stopList);
                        arr[i] = reportMap.get(reporter).size();
                    }
                }
            }
        return arr;
        }
}
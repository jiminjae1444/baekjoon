import java.util.*;
class Solution {
    public String[] solution(String[][] tickets) {
        return  findRoute(tickets).toArray(new String[0]);
    }

    private static List<String> findRoute(String[][] tickets) {
        List<String> list = new ArrayList<>();
        boolean[] visited = new boolean[tickets.length];
        List<String[]> sortTickets = new ArrayList<>(Arrays.asList(tickets));
            sortTickets.sort((a,b) ->{
            if (a[0].equals(b[0])) {
                return a[1].compareTo(b[1]);
            }
            return a[0].compareTo(b[0]);
        });
        // System.out.println(Arrays.deepToString(sortTickets.toArray()));
        dfs("ICN",visited,sortTickets,list);
        return list;
    }

    private static boolean dfs(String s, boolean[] visited, List<String[]> sortTickets, List<String> list) {
        list.add(s);
        if (list.size() ==sortTickets.size() + 1) {
            return true;
        }
        for (int i = 0; i < sortTickets.size(); i++) {
            if (!visited[i] && sortTickets.get(i)[0].equals(s)) {
                visited[i] = true;
                if (dfs(sortTickets.get(i)[1], visited, sortTickets, list)){
                    return true;
                }
                visited[i] = false;
            }
        }
        list.remove(list.size()-1);
        return false;
    }
}
import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        // int [][] computers ={{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        // int computerCount = 3;

        int answer = 0;
        HashSet<Integer> visited = new HashSet<>();

        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                dfs(i,visited, n,computers);
                answer+=1;
            }
        }
        return answer;
    }

    private static void dfs(int node, HashSet<Integer> visited, int n, int[][] computers) {
        visited.add(node);
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i) && computers[node][i] == 1) {
                dfs(i,visited,n,computers);
            }
        }
    }
}
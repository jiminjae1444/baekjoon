import java.util.*;

class Solution {
    static int count =0;
    public int solution(String begin, String target, String[] words) {
        bfs(begin,target,words);
        return count;
    }

    private static void bfs(String begin, String target, String[] words) {
        if (!Arrays.asList(words).contains(target)) {
            return;
        }
        Queue<String> queue = new LinkedList<>();
        queue.add(begin);
        boolean [] visited = new boolean[words.length];
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if (word.equals(target)) {
                    return;
                }
                for (int j = 0; j < words.length; j++) {
                    if(!visited[j] && canChangeword(word,words[j])) {
                            visited[j] = true;
                            queue.add(words[j]);
                    }
                }
            }
            count++;
        }
    }

    private static boolean canChangeword(String word, String word1) {
        int diff = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word.charAt(i)) {
                diff++;
            }
            if (diff > 1) {
                return false;
            }
        }
        return true;
    }
}
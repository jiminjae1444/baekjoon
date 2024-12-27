import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstLine = br.readLine().split(" ");
        HashMap<String, Integer> map = new HashMap<>();
        int N = Integer.parseInt(firstLine[0]);
        int M = Integer.parseInt(firstLine[1]);
        for (int i = 1; i <= N; i++) {
            String s = br.readLine();
            if (s.length() >= M) {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        list.sort((a, b) -> {
            int count1 = a.getValue();
            int count2 = b.getValue();
             if (count1 != count2) {
                return count2 - count1; 
            }
            int length1 = a.getKey().length();
            int length2 = b.getKey().length();
               if (length1 != length2) {
                return length2 - length1;
            }
            return a.getKey().compareTo(b.getKey());
        });
        for (Map.Entry<String, Integer> s: list) {
            bw.write(s.getKey() + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
import java.util.*;
class Solution {
    public int[] solution(String[] wallpaper) {
    int x_min = Integer.MAX_VALUE;
        int x_max = Integer.MIN_VALUE;
        int y_min = Integer.MAX_VALUE;
        int y_max = Integer.MIN_VALUE;
        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    x_min = Math.min(x_min, i);
                    y_min = Math.min(y_min, j);
                    x_max = Math.max(x_max, i);
                    y_max = Math.max(y_max, j);
                }
            }
        }
        // System.out.println(x_min);
        // System.out.println(y_min);
        // System.out.println(x_max+1);
        // System.out.println(y_max+1);
        List<Integer> list6 = new ArrayList<>();
        list6.add(x_min);
        list6.add(y_min);
        list6.add(x_max+1);
        list6.add(y_max+1);
        return list6.stream().mapToInt(i->i).toArray();
    }
}
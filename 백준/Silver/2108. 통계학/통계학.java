import java.util.*;

public class Main {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        HashMap<Integer,Integer> map = new HashMap<>();
        int [] arr = new int[N];
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            arr[i] = x;
            map.put(x,map.getOrDefault(x,0)+1);
        }
        Arrays.sort(arr);
        int sum=0;
        int max = Integer.MIN_VALUE;
        int min = 5000;
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> {
            int comp = b.getValue() - a.getValue(); 
            if (comp == 0) {
                return a.getKey() - b.getKey(); 
            }
            return comp;
        });
        for (Map.Entry<Integer, Integer> a : map.entrySet()) {
            sum+=a.getValue()*a.getKey();
            max=Math.max(a.getKey(),max);
            min=Math.min(a.getKey(),min);
        }
        sb.append(Math.round((double) sum/N)).append("\n");
        sb.append(arr[N/2]).append("\n");
        int mode = list.get(0).getKey(); // 최빈값
        if (list.size() > 1 && list.get(0).getValue() == list.get(1).getValue()) {
            mode = list.get(1).getKey();
        }
        sb.append(mode).append("\n");
        sb.append(max-min).append("\n");
        System.out.println(sb.toString());
    }
}
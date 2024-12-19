import java.util.*;
public class Main {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int N = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        HashMap<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < N; i++) {
           list.add(sc.nextInt());
        }
        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
           list2.add(sc.nextInt());
        }
        Collections.sort(list);
        for (int i = 0; i < N; i++) {
            map.put(list.get(i),map.getOrDefault(list.get(i),0)+1);
        }
        StringBuilder sb = new StringBuilder(); 
        for (int i = 0; i < M; i++) {
            int number = binarySearch(list2.get(i), list); 
            if (number == -1) {
                sb.append("0 "); 
            } else {
                sb.append(map.get(list.get(number))).append(" ");
            }
        }

        System.out.println(sb.toString().trim()); 
    }

    private static int binarySearch(int num, List<Integer> list) {
        int low = 0;
        int high = list.size()-1;
        while (high>=low){
            int mid = (low + high)/2;
            if(num==list.get(mid)){
                return mid;
            } else if (num>list.get(mid)) {
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return -1;
    }
}
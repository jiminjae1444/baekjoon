import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        int sum = 0;  // 총 사람 수
        Set<String> set = new HashSet<>();  // 한 세션에 등장한 사람들을 저장하는 Set

        for (int i = 0; i < N; i++) {
        String str = sc.nextLine();

            if (str.equals("ENTER")) {
                sum += set.size();  
                set.clear();   //equal이 나오면 set 초기화
            } else {
                set.add(str);
            }
        }
        //ENTER가 마지막엔 없는경우
        sum+=set.size();
        System.out.println(sum);
    }
}

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<int []> meetings = new ArrayList<int []>();
        for (int i = 0; i < N; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            meetings.add(new int [] {start, end});
        }

        meetings.sort((a,b)->{
            int comp = a[1]-b[1];
            if (comp == 0) return a[0]-b[0];
            return comp;
        });
        int count = 0;
        int lastTime = 0; // 마지막으로 배정된 회의의 끝 시간
        for (int [] meeting : meetings) {
            if (meeting[0] >= lastTime) {
                count++;
                lastTime = meeting[1];
            }
        }
        System.out.println(count);
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] step = new int[N];
        for (int i = 0; i < N; i++) {
            step[i] = Integer.parseInt(br.readLine());
        }
        int [] max = new int[N];

        if (N >= 1) max[0] = step[0];
        if (N >= 2) max[1] = Math.max(step[0] + step[1], step[1]);
        if (N >= 3) max[2] = Math.max(step[0] + step[2], step[1] + step[2]);

        for (int i = 3; i < N; i++) {
            max[i] = Math.max(max[i-2] + step[i], max[i-3] + step[i-1]+step[i]);
        }
        System.out.println(max[N-1]);

    }
}

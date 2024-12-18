import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    
        int[] sumarr = new int[N];
        sumarr[0] = arr[0];
        for (int i = 1; i < N; i++) {
            sumarr[i] = sumarr[i - 1] + arr[i];
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

       
            if (x == 1) {
                bw.write(sumarr[y - 1] + "\n");
            } else {
                bw.write((sumarr[y - 1] - sumarr[x - 2]) + "\n");
            }
        }

        bw.flush();
        bw.close(); 
        br.close(); 
    }
}
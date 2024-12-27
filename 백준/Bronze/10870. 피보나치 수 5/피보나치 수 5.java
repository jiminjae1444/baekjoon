import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstLine = br.readLine().split(" ");


        int N = Integer.parseInt(firstLine[0]);
        System.out.println(fivo(N));
        bw.flush();
        bw.close();
        br.close();
    }

    private static int fivo(int n) {
        if (n==0){
            return 0;
        }
        if (n==1){
            return  1;
        }
        if (n==2){
            return 1;
        }
        return fivo(n-1) + fivo(n-2);
    }
}
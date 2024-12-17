import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            separate(str, queue, bw);
        }

        bw.flush();
        br.close();
        bw.close();
    }

    private static void separate(String str, Queue<Integer> queue, BufferedWriter bw) throws IOException {
        if (str.contains(" ")) {
            queue.offer(Integer.parseInt(str.split(" ")[1]));
        } else if (str.equals("pop")) {
            bw.write(queue.isEmpty() ? "-1\n" : queue.poll() + "\n");
        } else if (str.equals("size")) {
            bw.write(queue.size() + "\n");
        } else if (str.equals("empty")) {
            bw.write(queue.isEmpty() ? "1\n" : "0\n");
        } else if (str.equals("front")) {
            bw.write(queue.isEmpty() ? "-1\n" : queue.peek() + "\n");
        } else if (str.equals("back")) {
            bw.write(lastQueue(queue) + "\n");
        }
    }

    private static int lastQueue(Queue<Integer> queue) {
        if (!queue.isEmpty()) {
            return ((ArrayDeque<Integer>)queue).peekLast();
        }
        return -1;
    }
}

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] next = new int[N];
        for (int i = 0; i < N; i++) {
            next[i] = Integer.parseInt(br.readLine());
        }

        boolean[] visited = new boolean[N];
        int current = 0;
        int count = 0;

        while (!visited[current]) {
            if (current == K) {
                System.out.println(count);
                return;
            }
            visited[current] = true;
            current = next[current];
            count++;
        }

        System.out.println(-1);
    }
}

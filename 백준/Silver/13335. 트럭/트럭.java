import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] trucks = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trucks[i] = Integer.parseInt(st.nextToken());
        }

        Queue<Integer> bridge = new ArrayDeque<>();
        for (int i = 0; i < w; i++) bridge.offer(0);

        int time = 0;
        int sum = 0;
        int idx = 0;

        while (!bridge.isEmpty()) {
            time++;

            // 한 칸 전진
            sum -= bridge.poll();

            // 다음 트럭 투입 시도
            if (idx < n && sum + trucks[idx] <= L) {
                bridge.offer(trucks[idx]);
                sum += trucks[idx];
                idx++;
            } else {
                bridge.offer(0);
            }

            // 모든 트럭이 올라간 뒤라면
            if (idx == n && sum == 0) break;
        }

        System.out.println(time);
    }
}

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
        for (int i = 0; i < n; i++) trucks[i] = Integer.parseInt(st.nextToken());

        Queue<Integer> bridge = new LinkedList<>();
        // 다리의 각 칸을 0으로 초기화 (길이 w)
        for (int i = 0; i < w; i++) bridge.add(0);

        int time = 0;
        int sumOnBridge = 0;
        int idx = 0; // 다음 대기 중인 트럭 인덱스

        while (idx < n) {
            time++;
            // 한 칸 이동: 앞칸(출구쪽) 제거
            sumOnBridge -= bridge.poll();

            // 다음 트럭이 올라갈 수 있으면 올리고, 아니면 0(빈칸) 추가
            if (sumOnBridge + trucks[idx] <= L) {
                bridge.add(trucks[idx]);
                sumOnBridge += trucks[idx];
                idx++;
            } else {
                bridge.add(0);
            }
        }

        // 모든 트럭이 다리 위에 올라간 뒤 남아있는 시간을 모두 흘려보냄
        while (sumOnBridge > 0) {
            time++;
            sumOnBridge -= bridge.poll();
        }

        System.out.println(time);
    }
}

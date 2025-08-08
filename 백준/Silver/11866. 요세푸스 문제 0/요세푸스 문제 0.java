import java.util.*;
import java.io.*;

public class Main {

    static String solution(int n, int k) {
        StringBuilder sb = new StringBuilder();
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            deque.addLast(i);
        }

        sb.append("<");
        while (!deque.isEmpty()) {
            // 현재 남은 사람 수만큼 나머지 연산으로 회전 횟수 줄이기
            int rotate = (k - 1) % deque.size();
            for (int j = 0; j < rotate; j++) {
                deque.offerLast(deque.pollFirst());
            }

            // K번째 사람 제거
            sb.append(deque.pollFirst());
            if (!deque.isEmpty()) sb.append(", ");
        }
        sb.append(">");

        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        System.out.println(solution(n, k));
    }
}

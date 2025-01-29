import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder()); // Long 타입 우선순위 큐

        for (int i = 0; i < n; i++) { // 반복문 조건 수정
            long x = Long.parseLong(br.readLine()); // x를 Long으로 입력받기

            if (x > 0) { // 자연수라면 큐에 추가
                pq.add(x);
            } else {
                if (!pq.isEmpty()) {
                    sb.append(pq.poll()).append("\n"); // 우선순위가 가장 높은 값 출력 후 제거
                } else {
                    sb.append(0).append("\n"); // 큐가 비어 있으면 0 출력
                }
            }
        }

        System.out.println(sb); // StringBuilder 출력
    }
}

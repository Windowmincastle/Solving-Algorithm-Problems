import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 카드 수
        int m = Integer.parseInt(st.nextToken()); // 합체 횟수

        // 카드 값을 저장할 최소 힙
        PriorityQueue<Long> pq = new PriorityQueue<>();
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            pq.add(Long.parseLong(st.nextToken()));
        }

        // m번 합체 진행
        for (int i = 0; i < m; i++) {
            long x = pq.poll();
            long y = pq.poll();
            long sum = x + y;
            pq.add(sum);
            pq.add(sum);
        }

        // 모든 카드의 합 계산
        long result = 0;
        while (!pq.isEmpty()) {
            result += pq.poll();
        }

        // 결과 출력
        System.out.println(result);
    }
}

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 결과 저장용 StringBuilder
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        
        // 절댓값을 기준으로 정렬하는 PriorityQueue 생성
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                // 절댓값이 다르면 절댓값 기준 정렬
                if (Math.abs(a) != Math.abs(b)) {
                    return Integer.compare(Math.abs(a), Math.abs(b));
                }
                // 절댓값이 같으면 실제 값 기준 정렬 (음수가 먼저 나오도록)
                return Integer.compare(a, b);
            }
        });
        
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                // 큐가 비어있다면 0 출력, 아니면 poll() 결과를 출력
                sb.append(pq.isEmpty() ? 0 : pq.poll()).append("\n");
            } else {
                pq.add(x);
            }
        }
        
        System.out.print(sb);
    }
}

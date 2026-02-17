import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        // 후보가 1명인 경우
        if (N == 1) {
            System.out.println(0);
            return;
        }

        int dasom = Integer.parseInt(br.readLine());
        
        // 최대 힙 (내림차순)
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 1; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int count = 0;

        while (!pq.isEmpty() && pq.peek() >= dasom) {
            int top = pq.poll();
            top--;        // 한 명 매수
            dasom++;      // 다솜 표 증가
            count++;

            pq.add(top);
        }

        System.out.println(count);
    }
}

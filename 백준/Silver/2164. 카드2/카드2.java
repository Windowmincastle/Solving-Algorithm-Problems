import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();

        // 큐 초기화
        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }

        // 큐 로직 처리
        while (q.size() > 1) {
            q.poll();               // 맨 앞의 요소 제거
            q.offer(q.poll());      // 그 다음 요소를 맨 뒤로 보냄
        }

        // 마지막 남은 요소 출력
        int answer = q.poll();      // 큐에 남은 마지막 요소
        System.out.println(answer);
    }
}

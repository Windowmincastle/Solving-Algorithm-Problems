import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        Queue<Integer> q = new ArrayDeque<>();

        // 1부터 n까지 카드 넣기
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }

        // 카드가 1장 남을 때까지 반복
        while (q.size() > 1) {
            // 버린 카드 출력
            sb.append(q.poll()).append(" ");
            // 다음 카드를 맨 뒤로 이동
            q.add(q.poll());
        }

        // 마지막 남은 카드 출력
        sb.append(q.poll());

        System.out.println(sb.toString());
    }
}

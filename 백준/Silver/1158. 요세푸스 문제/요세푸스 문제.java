import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력을 공백 기준으로 나누기 위해 StringTokenizer 사용
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 요세푸스 문제는 큐(Queue)를 사용하면 편리합니다.
        Queue<Integer> queue = new LinkedList<>();

        // 1부터 N까지 큐에 채워넣기
        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        // 큐에 사람이 1명 남을 때까지 반복
        while (queue.size() > 1) {
            // K-1명은 앞에서 빼서 뒤로 보냄
            for (int i = 0; i < K - 1; i++) {
                queue.offer(queue.poll());
            }
            // K번째 사람은 아예 제거하면서 출력 버퍼에 추가
            sb.append(queue.poll()).append(", ");
        }

        // 마지막 남은 사람 처리 (뒤에 쉼표 없음)
        sb.append(queue.poll()).append(">");

        System.out.println(sb);
    }
}
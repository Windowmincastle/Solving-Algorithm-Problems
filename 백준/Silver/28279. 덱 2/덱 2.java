import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> deque = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine()); // 명령 개수

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());

            switch (command) {
                case 1: // 덱 앞에 추가
                    deque.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case 2: // 덱 뒤에 추가
                    deque.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case 3: // 덱 앞에서 제거 후 출력
                    sb.append(deque.isEmpty() ? -1 : deque.pollFirst()).append("\n");
                    break;
                case 4: // 덱 뒤에서 제거 후 출력
                    sb.append(deque.isEmpty() ? -1 : deque.pollLast()).append("\n");
                    break;
                case 5: // 덱 크기 출력
                    sb.append(deque.size()).append("\n");
                    break;
                case 6: // 덱이 비었는지 확인
                    sb.append(deque.isEmpty() ? 1 : 0).append("\n");
                    break;
                case 7: // 덱 앞의 원소 출력
                    sb.append(deque.isEmpty() ? -1 : deque.peekFirst()).append("\n");
                    break;
                case 8: // 덱 뒤의 원소 출력
                    sb.append(deque.isEmpty() ? -1 : deque.peekLast()).append("\n");
                    break;
            }
        }
        System.out.print(sb);
    }
}

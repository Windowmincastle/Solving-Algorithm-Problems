import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // N: 큐의 크기, M: 뽑아낼 원소의 개수
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 뽑아낼 원소 리스트
        st = new StringTokenizer(br.readLine());
        List<Integer> target = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            target.add(Integer.parseInt(st.nextToken()));
        }

        // 양방향 큐 (Deque) 초기화
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }

        int operationCount = 0; // 최소 연산 횟수

        // 목표 원소 하나씩 제거
        for (int num : target) {
            // 현재 뽑아낼 원소의 인덱스
            int index = 0;
            for (Integer element : deque) {
                if (element == num) break;
                index++;
            }

            // 왼쪽과 오른쪽 이동 횟수 비교
            int left = index; // 왼쪽 이동 횟수
            int right = deque.size() - index; // 오른쪽 이동 횟수

            // 더 작은 이동 횟수를 선택
            if (left <= right) {
                // 왼쪽 이동
                for (int i = 0; i < left; i++) {
                    deque.addLast(deque.pollFirst());
                    operationCount++;
                }
            } else {
                // 오른쪽 이동
                for (int i = 0; i < right; i++) {
                    deque.addFirst(deque.pollLast());
                    operationCount++;
                }
            }

            // 뽑아내기 (1번 연산)
            deque.pollFirst();
        }

        // 결과 출력
        System.out.println(operationCount);
    }
}

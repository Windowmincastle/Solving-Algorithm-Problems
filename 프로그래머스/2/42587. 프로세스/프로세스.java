import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> q = new LinkedList<>(); // 프로세스 (우선순위, 위치) 저장
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // 우선순위 큐 (최대값 추적)

        // 1️⃣ 초기 데이터 삽입
        for (int i = 0; i < priorities.length; i++) {
            q.add(new int[]{priorities[i], i});
            pq.add(priorities[i]);
        }

        int executionOrder = 0; // 실행 순서 카운트

        // 2️⃣ 큐에서 프로세스를 하나씩 처리
        while (!q.isEmpty()) {
            int[] current = q.poll(); // 현재 프로세스 가져오기
            int priority = current[0]; // 우선순위
            int index = current[1]; // 원래 위치

            // 3️⃣ 현재 프로세스가 가장 높은 우선순위인지 확인
            if (priority == pq.peek()) {
                executionOrder++; // 실행 횟수 증가
                pq.poll(); // 우선순위 큐에서도 제거

                // 🔹 찾던 프로세스라면 실행 순서 반환
                if (index == location) return executionOrder;
            } else {
                // ❌ 더 높은 우선순위가 있으면 다시 큐에 추가
                q.add(current);
            }
        }

        return -1; // (실제로 도달하지 않는 코드)
    }
}

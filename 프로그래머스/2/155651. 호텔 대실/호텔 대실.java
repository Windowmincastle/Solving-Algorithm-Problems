import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        // 1. 시간을 분 단위로 변환해서 저장
        int[][] time = new int[book_time.length][2];
        for (int i = 0; i < book_time.length; i++) {
            time[i][0] = toMinutes(book_time[i][0]);
            time[i][1] = toMinutes(book_time[i][1]) + 10; // 청소 시간 10분 추가
        }

        // 2. 시작 시간 기준으로 정렬
        Arrays.sort(time, (a, b) -> Integer.compare(a[0], b[0]));

        // 3. 우선순위 큐로 퇴실+청소 시간 관리 (오름차순)
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int[] t : time) {
            // 방이 하나라도 재사용 가능하다면 제거
            if (!pq.isEmpty() && pq.peek() <= t[0]) {
                pq.poll();
            }
            pq.offer(t[1]); // 현재 예약의 종료+청소 시간 추가
        }

        // 4. 큐에 남아 있는 방 수가 필요한 최소 객실 수
        return pq.size();
    }

    private int toMinutes(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
}

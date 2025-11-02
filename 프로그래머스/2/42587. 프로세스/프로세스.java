import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> queue = new LinkedList<>(); // {priority, index}

        // 큐 초기화
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new int[]{priorities[i], i});
        }

        int order = 0; // 실행 순서

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int priority = current[0];
            int index = current[1];

            // 큐 안에 더 높은 우선순위가 있는지 확인
            boolean hasHigher = false;
            for (int[] p : queue) {
                if (p[0] > priority) {
                    hasHigher = true;
                    break;
                }
            }

            if (hasHigher) {
                // 다시 뒤로 넣음
                queue.add(current);
            } else {
                // 실행
                order++;
                if (index == location) {
                    return order;
                }
            }
        }

        return -1; // 이 경우는 발생하지 않음
    }
}

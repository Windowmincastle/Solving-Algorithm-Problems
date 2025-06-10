import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        // 이미 계산한 숫자들을 저장하고, 중복 방문 방지를 위해 boolean 배열 사용
        boolean[] visited = new boolean[y + 1];
        
        // BFS를 위한 큐: [현재 값, 연산 횟수]
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, 0});
        visited[x] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int value = current[0];
            int count = current[1];

            // y에 도달하면 연산 횟수를 반환
            if (value == y) {
                return count;
            }

            // 가능한 다음 연산들
            int[] nextValues = new int[] {
                value + n,
                value * 2,
                value * 3
            };

            for (int next : nextValues) {
                // y 이하이고 아직 방문하지 않았다면 큐에 추가
                if (next <= y && !visited[next]) {
                    visited[next] = true;
                    queue.offer(new int[] {next, count + 1});
                }
            }
        }

        // y로 도달할 수 없는 경우
        return -1;
    }
}

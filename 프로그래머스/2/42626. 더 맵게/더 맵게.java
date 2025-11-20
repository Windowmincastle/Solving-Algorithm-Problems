import java.util.PriorityQueue;
import java.util.Arrays;

class Solution {
    public int solution(int[] scoville, int K) {
        // 1. 최소 힙(Min-Heap)을 생성합니다.
        // Java의 PriorityQueue는 기본적으로 최소 힙입니다.
        PriorityQueue<Long> minHeap = new PriorityQueue<>();

        // 2. 모든 스코빌 지수를 힙에 삽입합니다.
        // K의 범위(최대 10억)와 스코빌 지수의 연산 결과(최대 30억 이상 가능)를 고려하여 
        // 데이터 타입을 Long으로 사용하는 것이 안전합니다.
        for (int s : scoville) {
            minHeap.offer((long) s);
        }

        int mixCount = 0; // 섞은 횟수

        // 3. 힙의 최소 원소(peek)가 K 미만인 동안 반복합니다.
        // 힙이 비어있지 않아야 합니다.
        while (minHeap.peek() < K) {
            
            // 섞을 음식이 2개 미만인 경우 (힙의 크기가 1 이하)
            // 더 이상 섞는 것이 불가능합니다.
            if (minHeap.size() < 2) {
                // 남은 하나의 음식도 K 미만이라면 만들 수 없으므로 -1 반환
                // (while 조건에서 이미 minHeap.peek() < K 임이 확인되었음)
                return -1;
            }

            // 4. 스코빌 지수가 가장 낮은 두 개의 음식을 꺼냅니다.
            long first = minHeap.poll();  // 가장 맵지 않은 음식
            long second = minHeap.poll(); // 두 번째로 맵지 않은 음식

            // 5. 새로운 음식의 스코빌 지수를 계산합니다.
            // 새로운 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
            long newScoville = first + (second * 2);

            // 6. 새로운 스코빌 지수를 다시 힙에 넣습니다.
            minHeap.offer(newScoville);

            // 7. 섞은 횟수를 증가시킵니다.
            mixCount++;
        }

        // 8. 모든 음식이 K 이상이 되었다면 섞은 횟수(mixCount)를 반환합니다.
        return mixCount;
    }
}
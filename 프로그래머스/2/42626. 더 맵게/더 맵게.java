import java.util.PriorityQueue;
class Solution {

    public int solution(int[] scoville, int K) {
        int ans = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < scoville.length; i++) {

            // 우선순위큐에 주어진 scoville 배열의 데이터를 모두 넣는다.
            // 기본적으로 PriorityHeap는 최소힙으로 동작한다.
            queue.add(scoville[i]);

        }

        while (queue.peek() < K) { // 스코빌지수가 k보다 낮다면 진입한다.

            if (queue.size() == 1) { // 종료조건
                return -1;
            }

            // while 조건을 만족해야 26라인을 실행한다
            queue.add(queue.poll() + queue.poll() * 2);
            ans++; // 카운트 샌다.
        }
        return ans;

    }
}

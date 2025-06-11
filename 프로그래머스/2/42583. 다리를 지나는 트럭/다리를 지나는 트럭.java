import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();
        int time = 0;
        int bridgeWeight = 0;
        int index = 0;

        // 초기 다리 상태를 0으로 채움
        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }

        while (index < truck_weights.length) {
            // 1초가 지남
            time++;

            // 다리에서 트럭 한 대(or 빈공간) 나감
            bridgeWeight -= bridge.poll();

            // 다음 트럭이 다리에 올라갈 수 있는지 확인
            if (bridgeWeight + truck_weights[index] <= weight) {
                bridge.offer(truck_weights[index]);
                bridgeWeight += truck_weights[index];
                index++;
            } else {
                // 올라갈 수 없으면 0을 넣어서 공간만 채움
                bridge.offer(0);
            }
        }

        // 마지막 트럭이 다리를 건너는 시간까지 추가
        return time + bridge_length;
    }
}

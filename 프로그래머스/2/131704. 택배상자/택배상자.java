import java.util.*;

class Solution {
    public int solution(int[] order) {
        Stack<Integer> stack = new Stack<>();  // 보조 컨테이너 벨트 (LIFO)
        int idx = 0;  // order 배열에서 몇 번째를 실어야 하는지 가리키는 인덱스
        int n = order.length;
        
        // 1번 ~ n번 상자를 메인 벨트에서 차례대로 꺼냄
        for (int box = 1; box <= n; box++) {
            // 메인 벨트에서 꺼낸 상자가 지금 실어야 할 상자라면
            if (box == order[idx]) {
                idx++;
            } else {
                // 아니라면 보조 벨트에 넣음
                stack.push(box);
            }
            
            // 그 후, 보조 벨트에 있는 top을 계속 확인해서 
            // 실어야 할 상자(order[idx])가 있다면 꺼내서 실음
            while (!stack.isEmpty() && stack.peek() == order[idx]) {
                stack.pop();
                idx++;
            }
        }
        
        // idx는 실은 상자의 개수
        return idx;
    }
}

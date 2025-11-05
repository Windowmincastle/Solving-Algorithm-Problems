import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];
        Arrays.fill(answer, -1); // 기본값 -1로 초기화
        Stack<Integer> stack = new Stack<>();

        // 뒤에서 앞으로 순회
        for (int i = n - 1; i >= 0; i--) {
            // 현재 수보다 작거나 같은 수는 의미 없음 (뒤 큰수가 될 수 없음)
            while (!stack.isEmpty() && numbers[stack.peek()] <= numbers[i]) {
                stack.pop();
            }

            // 스택이 비어 있지 않다면 -> 현재 수의 뒤 큰수는 스택 top의 숫자
            if (!stack.isEmpty()) {
                answer[i] = numbers[stack.peek()];
            }

            // 현재 인덱스 push
            stack.push(i);
        }

        return answer;
    }
}

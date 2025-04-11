import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];            // 결과를 저장할 배열
        Stack<Integer> stack = new Stack<>(); // 인덱스를 저장할 스택

        // 뒤에서부터 탐색 시작
        for (int i = n - 1; i >= 0; i--) {
            int current = numbers[i];

            // 현재 숫자보다 작거나 같은 값들은 스택에서 제거
            while (!stack.isEmpty() && stack.peek() <= current) {
                stack.pop();
            }

            // 스택이 비어있으면 뒷 큰수가 없는 것 → -1
            // 아니면 peek()가 뒷 큰수
            answer[i] = stack.isEmpty() ? -1 : stack.peek();

            // 현재 값을 스택에 push (다음 비교를 위해)
            stack.push(current);
        }

        return answer;
    }
}

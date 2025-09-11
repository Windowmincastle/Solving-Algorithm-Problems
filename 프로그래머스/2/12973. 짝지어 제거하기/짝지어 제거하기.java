import java.util.*;

class Solution {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop(); // 짝 제거
            } else {
                stack.push(c); // 새로운 문자 추가
            }
        }
        
        return stack.isEmpty() ? 1 : 0;
    }
}

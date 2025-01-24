import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 효율적으로 받기 위해 BufferedReader 사용
        StringBuilder result = new StringBuilder(); // 결과를 저장할 StringBuilder

        while (true) {
            String line = br.readLine(); // 한 줄 입력받음
            
            if (line.equals(".")) break; // "."만 입력되면 종료

            // 문자열이 균형 잡혀 있다면 "yes", 아니면 "no" 추가
            if (isBalanced(line)) {
                result.append("yes\n");
            } else {
                result.append("no\n");
            }
        }

        // 결과 출력
        System.out.print(result);
    }

    private static boolean isBalanced(String line) {
        Stack<Character> stack = new Stack<>(); // 괄호를 저장할 스택

        for (char ch : line.toCharArray()) { // 문자열의 각 문자 순회
            if (ch == '(' || ch == '[') {
                stack.push(ch); // 왼쪽 괄호는 스택에 추가
            } else if (ch == ')') {
                if (stack.isEmpty() || stack.pop() != '(') { // 스택이 비었거나 짝이 맞지 않으면 false
                    return false;
                }
            } else if (ch == ']') {
                if (stack.isEmpty() || stack.pop() != '[') { // 스택이 비었거나 짝이 맞지 않으면 false
                    return false;
                }
            }
        }

        return stack.isEmpty(); // 스택이 비어 있으면 균형, 그렇지 않으면 균형 아님
    }
}

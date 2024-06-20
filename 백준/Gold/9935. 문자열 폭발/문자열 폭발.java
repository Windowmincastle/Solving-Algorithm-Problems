import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        // 예제 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String bomb = br.readLine();
        
        // 폭발 문자열 제거 후 결과 출력
        System.out.println(removeBombString(str, bomb));
    }

    public static String removeBombString(String str, String bomb) {
        Stack<Character> stack = new Stack<>();
        int bombLength = bomb.length(); // 폭발 문자열의 길이

        // 입력 문자열을 한 문자씩 순회
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i)); // 현재 문자를 스택에 추가

            // 스택의 크기가 폭발 문자열의 길이 이상일 때
            if (stack.size() >= bombLength) {
                // 스택의 마지막 부분이 폭발 문자열과 일치하는지 확인
                boolean match = true;
                for (int j = 0; j < bombLength; j++) {
                    // 스택의 마지막 부분과 폭발 문자열을 비교
                    if (stack.get(stack.size() - bombLength + j) != bomb.charAt(j)) {
                        match = false;
                        break; // 일치하지 않으면 비교 중단
                    }
                }
                // 폭발 문자열과 일치하면
                if (match) {
                    // 폭발 문자열 길이만큼 스택에서 제거
                    for (int j = 0; j < bombLength; j++) {
                        stack.pop();
                    }
                }
            }
        }

        // 스택에 남아있는 문자들을 문자열로 변환
        StringBuilder result = new StringBuilder();
        for (char ch : stack) {
            result.append(ch);
        }

        // 남은 문자가 없으면 "FRULA" 반환
        return result.length() == 0 ? "FRULA" : result.toString();
    }
}

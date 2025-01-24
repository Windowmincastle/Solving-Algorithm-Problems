import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < T; i++) {
            String str = br.readLine();
            if (isValid(str)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
    
    static boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : str.toCharArray()) {
            if (c == '(') {
                stack.push(c); // 여는 괄호를 스택에 추가한다.
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop(); // 여는 괄호를 제거하며 괄호의 쌍을 맞춘다.
            }
        }
        
        // 스택이 비어있으면 YES, 남아 있으면 NO
        return stack.isEmpty();
    }
}

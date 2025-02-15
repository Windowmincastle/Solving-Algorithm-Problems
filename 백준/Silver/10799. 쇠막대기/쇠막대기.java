import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String input = br.readLine();
        Stack<Character> stack = new Stack<>();
        int result = 0;
        
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            
            // 여는 괄호일 경우 스택에 넣음
            if (ch == '(') {
                stack.push(ch);
            } else { // 닫는 괄호일 경우
                stack.pop(); // 일단 pop해서 짝 맞추기
                
                if (input.charAt(i - 1) == '(') {
                    // 이전 문자가 '('이면 레이저
                    result += stack.size(); // 현재 스택에 남아있는 막대기 개수만큼 추가
                } else {
                    // 이전 문자가 '('이 아니면 막대기의 끝
                    result += 1; // 끝부분 조각 1개 추가
                }
            }
        }
        
        sb.append(result).append("\n");
        System.out.print(sb);
    }
}

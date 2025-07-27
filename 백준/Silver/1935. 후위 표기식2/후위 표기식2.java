import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1) 빠른 입력 도구 준비
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 2) 피연산자 개수 N
        int N = Integer.parseInt(br.readLine());
        
        // 3) 후위 표기식 문자열
        String expr = br.readLine().trim();
        
        // 4) A~Z에 대응되는 값을 저장할 배열
        double[] value = new double[26];
        for (int i = 0; i < N; i++) {
            // A는 0, B는 1, ... 순서대로 읽어서 저장
            value[i] = Double.parseDouble(br.readLine());
        }
        
        // 5) 스택을 이용해 후위 표기식 계산
        Stack<Double> stack = new Stack<>();
        for (char c : expr.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                // 피연산자면 배열에서 값 꺼내서 push
                stack.push(value[c - 'A']);
            } else {
                // 연산자면 스택에서 두 개 꺼내서 계산
                double b = stack.pop();
                double a = stack.pop();
                switch (c) {
                    case '+': stack.push(a + b); break;
                    case '-': stack.push(a - b); break;
                    case '*': stack.push(a * b); break;
                    case '/': stack.push(a / b); break;
                }
            }
        }
        
        // 6) 결과를 소수점 둘째 자리까지 출력
        double result = stack.pop();
        System.out.printf("%.2f\n", result);
        
        br.close();
    }
}

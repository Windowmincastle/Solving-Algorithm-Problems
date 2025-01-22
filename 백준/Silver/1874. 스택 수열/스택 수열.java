import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 수열의 길이 입력받기
        int[] target = new int[n]; // 목표 수열을 저장할 배열

        // 목표 수열 입력받기
        for (int i = 0; i < n; i++) {
            target[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>(); // 스택 선언
        StringBuilder sb = new StringBuilder(); // 결과를 저장할 StringBuilder
        int cur = 1; // 스택에 push할 숫자 (1부터 시작)

        // 목표 수열 처리
        for (int num : target) {
            // 목표 숫자에 도달할 때까지 push
            while (cur <= num) {
                stack.push(cur); // 숫자를 스택에 추가
                sb.append("+\n"); // push 연산 기록
                cur++; // 다음 숫자로 이동
            }

            // 스택의 최상단 숫자가 목표 숫자와 일치하면 pop
            if (stack.peek() == num) {
                stack.pop(); // 스택에서 제거
                sb.append("-\n"); // pop 연산 기록
            } else {
                // 스택의 최상단이 목표 숫자와 다르면 불가능
                System.out.println("NO");
                return;
            }
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}

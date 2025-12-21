import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int current = 1; // 다음에 push할 숫자

        for (int i = 0; i < n; i++) {
            int target = Integer.parseInt(br.readLine());

            // target까지 push
            while (current <= target) {
                stack.push(current);
                sb.append("+\n");
                current++;
            }

            // 스택 top이 target이면 pop
            if (!stack.isEmpty() && stack.peek() == target) {
                stack.pop();
                sb.append("-\n");
            } else {
                // 만들 수 없는 경우
                System.out.println("NO");
                return;
            }
        }

        // 정상적으로 모두 처리된 경우
        System.out.print(sb.toString());
    }
}

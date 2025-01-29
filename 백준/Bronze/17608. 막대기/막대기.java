import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] heights = new int[n];
        
        for(int i = 0; i < n; i++) {
            heights[i] = Integer.parseInt(br.readLine());
        }

        // 스택을 사용하여 가장 높은 막대기를 찾고 카운트
        Stack<Integer> stack = new Stack<>();
        int visibleCount = 0;

        // 오른쪽에서 왼쪽으로 막대기 높이를 확인
        for(int i = n - 1; i >= 0; i--) {
            // 현재 막대기가 스택의 맨 위보다 크면 보이는 막대기
            if(stack.isEmpty() || heights[i] > stack.peek()) {
                visibleCount++;
                stack.push(heights[i]); // 스택에 높이 저장
            }
        }
        
        System.out.println(visibleCount); // 보이는 막대기의 수 출력
    }
}

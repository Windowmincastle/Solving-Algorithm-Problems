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
            // 스택이 비어있는 경우는 맨 처음에 가장 우측에서 막대기를 바라본 경우이다 그러니 무조건 +1
            // 나는 가장 우측의 막대기 크기가 10이라면 10보다 큰 막대기들의 갯수만 카운트하면 된다고 생각햇다
            // 그러나 만약 11 15 14 10 이라면 가장 왼쪽의 11은 10보다 크지만 15에 가려져서 보이지 않기 때문에
            // 스택에 높이를 우측에서 왼쪽으로 가면서 값을 갱신하고 스택의 top과 비교하는 막대기의 높이를 비교해야하는 것 이다.
            
            if(stack.isEmpty() || heights[i] > stack.peek()) {
                visibleCount++;
                stack.push(heights[i]); // 스택에 높이 저장
            }
        }
        
        System.out.println(visibleCount); // 보이는 막대기의 수 출력
    }
}

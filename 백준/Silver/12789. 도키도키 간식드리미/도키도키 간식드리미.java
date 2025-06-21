import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        Stack<Integer> side = new Stack<>();
        int expect = 1;  // 다음에 받아야 할 번호표
        
        for (int i = 0; i < N; i++) {
            int curr = Integer.parseInt(st.nextToken());
            
            // 가능하다면 side 스택에서 꺼내기
            while (!side.isEmpty() && side.peek() == expect) {
                side.pop();
                expect++;
            }
            
            if (curr == expect) {
                // 바로 받아줄 수 있는 번호면 바로 처리
                expect++;
            } else {
                // 아니면 side 스택에 대기
                side.push(curr);
            }
        }
        
        // 남은 사람들도 처리
        while (!side.isEmpty() && side.peek() == expect) {
            side.pop();
            expect++;
        }
        
        // 모든 번호를 순서대로 처리했는지 확인
        if (expect == N + 1) {
            System.out.println("Nice");
        } else {
            System.out.println("Sad");
        }
    }
}

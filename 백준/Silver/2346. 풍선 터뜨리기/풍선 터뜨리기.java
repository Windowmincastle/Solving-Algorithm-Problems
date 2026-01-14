import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()); // split보다 효율적인 방식
        
        int[] moves = new int[n];
        for (int i = 0; i < n; i++) {
            moves[i] = Integer.parseInt(st.nextToken());
        }
        
        Deque<int[]> dq = new ArrayDeque<>();
        
        // 덱에 {풍선번호, 적힌값} 추가
        for (int i = 1; i <= n; i++) {
            dq.add(new int[]{i, moves[i-1]});
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!dq.isEmpty()) {
            // 1. 현재 풍선을 터뜨림
            int[] current = dq.pollFirst();
            int pNum = current[0];
            int move = current[1];
            
            sb.append(pNum).append(" ");
            
            // 덱이 비었으면 종료
            if (dq.isEmpty()) break;
            
            // 2. 이동 로직
            if (move > 0) {
                // 양수일 때: (move - 1)번 앞에서 빼서 뒤로
                for (int i = 0; i < move - 1; i++) {
                    dq.addLast(dq.pollFirst());
                }
            } else {
                // 음수일 때: (절댓값)번 뒤에서 빼서 앞으로
                for (int i = 0; i < Math.abs(move); i++) {
                    dq.addFirst(dq.pollLast());
                }
            }
        }
        // 최종 결과 한 번에 출력
        System.out.println(sb.toString().trim());
    }
}
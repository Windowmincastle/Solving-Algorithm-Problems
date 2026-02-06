import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int k = Integer.parseInt(inputs[1]);
        List<Integer> removeLst = new ArrayList<>();
        
        Deque<Integer> dq = new ArrayDeque<>();
        
        for (int i=1; i<=n; i++) {
            dq.offer(i);
        }
        
        // 3,6,2,7,5,1,4 라고 가정
        /* 정답 <3,5,
            1 2 3 4 5 6 7
        idx 1 2 3 -> 3제거
        -> 4 5 6 7 1 2 3
        idx1 2 3 -> 6 제거
        ->  7 1 2 3 4 5
        idx 1 2 3 -> 2 제거
        
        이런 패턴의 규칙이 뭐냐? k-1번 건너뛰고 제거
        k-1번 건너 뛰고 제거 
        k-1번 건너 뛰고 제거
        */
        
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        
        // 어떻게 ? 표현 ? 할까? 반복문? 2번 건너뛰고? 아니지 n번 반복하면되지
        for (int i=0; i<n; i++) {
            
            //dq로 2번 보내고 -> 제거 k번 반복
            for (int j=0; j<k-1; j++) {
                // 뒤로 k-1번 보내, 앞에 n-1개를 
                dq.offerLast(dq.poll());
            }
            removeLst.add(dq.poll()); // 1번 제거
        }
        
        for (int i=0; i<removeLst.size(); i++) {
            
            if ( i == removeLst.size()-1) {
                sb.append(removeLst.get(i)).append(">");
            } else {
                sb.append(removeLst.get(i)).append(", ");
            }
        }
        
        System.out.println(sb.toString());
    }
}
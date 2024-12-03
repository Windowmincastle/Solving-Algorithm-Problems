
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int TC = Integer.parseInt(br.readLine());
        
        for (int T = 0; T < TC; T++){

            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);
            
            String[] pri = br.readLine().split(" ");

            //우선순위큐 : 중요도를 기준으로 내림차순 정렬
            
            PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[1]-a[1]);

            Queue<int[]> Q = new LinkedList<>();
            
            for (int i=0; i<N; i++){
                
                int priority = Integer.parseInt(pri[i]);
                
                Q.add(new int[]{i,priority}); // 큐에 {문서 위치, 중요도}를 넣음
                pq.add(new int[]{i,priority}); // 우선순위 큐에도 넣음

            }

            int cnt = 0;

            
            while (!Q.isEmpty()){
                
                int[] cur = Q.poll();
                
                if(cur[1] == pq.peek()[1]){
                    pq.poll();
                    cnt++;
                    if(cur[0] == M ){
                        sb.append(cnt).append("\n");
                        break;
                    }
                } else {
                    Q.add(cur);
                }
            
            }

        }
        System.out.print(sb);
        
    }
    
}

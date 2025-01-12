import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
        //각 줄에 하나의 값이 들어오는 구조라서 StringTokenizer를 사용할 필요가 없다.

        int n = Integer.parseInt(br.readLine());
        int dasom = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=1; i<n; i++){
            pq.offer(Integer.parseInt(br.readLine()));
        }
        
        int cnt = 0;
        
        while( !pq.isEmpty() && dasom <= pq.peek()) {
            
            int maxVotes = pq.poll();
            pq.offer(maxVotes -1);
            
            dasom++;
            cnt++;
            
        }
        
        System.out.println(cnt);
        

    }
    
}

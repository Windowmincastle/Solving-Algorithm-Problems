import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i=0; i<n; i++){
            
            long x = Long.parseLong(br.readLine());
            
            if(x > 0 && x < Long.MAX_VALUE){ // x가 자연수라면 pq에 값을 넣는다.
                pq.add(x);
            } else {
                
                if(!pq.isEmpty()){
                    sb.append(pq.poll()).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            }
        }
      
        System.out.println(sb);
    }
    
}
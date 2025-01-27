import java.io.*;
import java.util.*;

public class Main{
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0; i<n; i++){
            
            int input = Integer.parseInt(br.readLine());
            
            if( input > 0 && n < Long.MAX_VALUE ){
                
                pq.add(input);
                
            } else if ( input == 0){
                
                if( pq.peek() == null){
                    sb.append("0").append("\n");
                } else {
                    sb.append(pq.poll()).append("\n");
                }
            }
            
        }
        
        System.out.print(sb);
        
    }
    
}
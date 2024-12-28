import java.io.*;
import java.util.*;

public class Main{
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        int[] tallerCnt = new int[n];
        int[] answer = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i=0; i<n; i++){
            tallerCnt[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i=0; i<n; i++){
            
            int cnt = tallerCnt[i];
            
            for (int j=0; j<n; j++){
                
                if( cnt==0 && answer[j]==0){
                    answer[j] = i+1;
                    break;
                }
                
                if(answer[j] == 0){
                    cnt--;
                }
                
            }
            
        }
        
        for( int ans : answer ){
            sb.append(ans).append(" ");
        }
        System.out.println(sb);
        
    }
    
}
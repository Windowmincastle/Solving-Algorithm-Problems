import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        
        int[] days = new int[n];
        st = new StringTokenizer(br.readLine());
        
        for (int i=0; i<n; i++) {
             days[i] = Integer.parseInt(st.nextToken());   
        }
        
        int answer = 0, sum = 0, count =0;
        for (int j=0; j<x; j++) {
            sum+= days[j];
        }
        
        answer = Math.max(answer,sum);
        count = 1;
        
        for (int k=x; k<n; k++) {
            sum -= days[k-x];
            sum += days[k];
            
            if ( sum > answer ) {
                answer = Math.max(answer,sum);
                count = 1;
            } else if ( sum == answer){
                count++;
            }
            
        }
        
        if ( answer == 0 ){
            System.out.println("SAD");
        } else {
            System.out.println(answer);
            System.out.println(count);
        }
        
    }
    
}
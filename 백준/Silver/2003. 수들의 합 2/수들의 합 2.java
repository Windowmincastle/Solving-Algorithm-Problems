import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] ary = new int[n];
        st = new StringTokenizer(br.readLine());
        
        for (int i=0; i<n; i++) {
            ary[i] = Integer.parseInt(st.nextToken());
        }
        
        int sum = 0;
        int count = 0;
        int end = 0;
        
        for (int start = 0; start<n; start++) {
            
            while ( sum < m && end < n){
                sum += ary[end];
                end++;
            }
            
            if ( sum == m) {
                count++;
            }
            
            sum -= ary[start];
        }
        
        System.out.println(count);
    }
    
}
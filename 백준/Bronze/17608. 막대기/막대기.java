import java.io.*;
import java.util.*;

public class Main {
    
    public static int solution(int lastValue, int n, int[] ary){
        
        int currentMax = ary[ary.length-1];
        int count = 1;
        
        for(int i=ary.length-2; i>=0; i--){
            
            if ( ary[i] > currentMax){
                currentMax = ary[i];
                count++;
            }
            
        }
        
        return count;
    }
   
        
    public static void main (String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int[] ary = new int[n];
        
        for (int i=0; i<n; i++){
            int temp = Integer.parseInt(br.readLine());
            ary[i] = temp;
        }
        
        int lastValue = ary[n-1];
        int answer = solution(lastValue, n, ary);
        
        System.out.println(answer);
    }
}
import java.util.*;
import java.io.*;

public class Main{
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        
        for(int i=1; i<=n; i++){
            
            if( i < 100 ){
                count++;
                continue;
            }
            
            String str = String.valueOf(i);
            
            int[] numbers = new int[str.length()];
            
            for(int j = 0; j< str.length(); j++){
                
                numbers[j] = str.charAt(j) - '0';
            }
            
            int standard = numbers[1] - numbers[0];
            for (int k = 2; k<str.length(); k++){
                
                if ( numbers[k] - numbers[k-1] == standard ){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
    
}
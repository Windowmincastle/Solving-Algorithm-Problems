import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        
        int[] ary = new int[n];
        
        for (int i=0; i<ary.length; i++) {
            ary[i] = i+1;
        }
        
        for (int k=0; k<m; k++) {
            
            String[] range = br.readLine().split(" ");
            int i = Integer.parseInt(range[0]);
            int j = Integer.parseInt(range[1]);
            
            int left = i - 1;
            int right = j - 1;
            
            while (left < right) {
                int temp = ary[left];
                ary[left] = ary[right];
                ary[right] = temp;
            
                left++;
                right--;
            }
            
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int num : ary ) {
            
            sb.append(num).append(" ");
            
        }
        
        System.out.println(sb.toString());
        
    }
}
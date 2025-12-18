import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for (int i=0; i<n; i++){
            String[] input = br.readLine().split(" ");
            int r = Integer.parseInt(input[0]);
            String words = input[1];
            
            char[] ary = words.toCharArray();
            
            for (int j=0; j<ary.length; j++){
                
                for (int k=0; k<r; k++){
                    sb.append(ary[j]);    
                }
            
            }
            sb.append("\n");
        }
        
        System.out.println(sb.toString());
    }
}
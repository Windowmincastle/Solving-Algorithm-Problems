import java.io.*;
import java.util.*;

public class Main{
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int m = 2;
        int[][] ary = new int[n][m];

        for (int i=0; i<n; i++){

            String[] input = br.readLine().split(" ");
            
            ary[i][0] = Integer.parseInt(input[0]);
            ary[i][1] = Integer.parseInt(input[1]);
        
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int j=0; j<n; j++){

            int count = 1;    
            
            for (int k=0; k<n; k++){
                
                if( ary[j][0] < ary[k][0] && ary[j][1] < ary[k][1] ){
                    count++;
                }
            }
            sb.append(count).append(" ");
        }
        
        System.out.println(sb);
    }
}
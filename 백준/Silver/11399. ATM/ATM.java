import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        
        int[] ary = new int[input.length];
        for (int i=0; i<input.length; i++){
            ary[i] = Integer.parseInt(input[i]);
        }
        
        Arrays.sort(ary);
        
        int sum    = 0;
        int answer = 0;
        
        for (int i=0; i<ary.length; i++){
            sum += ary[i];
            answer += sum;
            
        }
        
        System.out.println(answer);
    }
    
}
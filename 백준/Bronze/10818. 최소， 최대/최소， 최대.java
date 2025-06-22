import java.util.*;
import java.io.*;

public class Main{
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        int[] ary = new int[str.length];
        
        for (int i=0; i<str.length; i++){
            ary[i] = Integer.parseInt(str[i]);
        }
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for (int j=0; j<str.length; j++){
            max = Math.max(max,ary[j]);
            min = Math.min(min,ary[j]);
        }
        
        System.out.println(min+" "+max);
        
    }
}
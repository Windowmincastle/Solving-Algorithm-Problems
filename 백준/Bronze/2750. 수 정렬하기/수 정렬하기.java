import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] ary = new int[n];
        
        for (int i=0; i<n; i++) {
            ary[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(ary);
        
        StringBuilder sb = new StringBuilder();
        
        for (int i=0; i<n; i++) {
            sb.append(ary[i]).append("\n");
        }
        
        System.out.println(sb.toString());

    }
}
import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        
        long result = (long)(a * b * c);
        int[] resultAry = new int[10];
        
        // result를 문자열로 바꾼다. -> 하나씩 숫자를 체크하고 idx에 +를 한다.
        String resToStr = String.valueOf(result);
        
        for (int i=0; i<resToStr.length(); i++) {
           int num = resToStr.charAt(i) - '0';
           resultAry[num]++; 
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i=0; i<resultAry.length; i++) {
            sb.append(resultAry[i]).append("\n");
        }
        
        System.out.println(sb);
        
    }
    
}
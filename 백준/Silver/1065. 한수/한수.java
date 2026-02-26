import java.io.*;
import java.util.*;

public class Main {
    
    public static boolean isHansu(int num) {
        
        if (num < 100) return true;
        if (num == 1000) return false;
        
        // 세자릿수만 판별하면된다.
        int hundreds = num / 100; // 백의 자리
        int tens = (num / 10) % 10; // 십의 자리
        int ones = num % 10; // 일의 자리
        
        if ((hundreds - tens) == (tens-ones)) return true;
        
        return false;
    }
    
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int count = 0;
        
        for (int i=1; i<=n; i++) {
            
            if(isHansu(i)){
                count++;
            }
        }
        
        System.out.println(count);
    }
    
}
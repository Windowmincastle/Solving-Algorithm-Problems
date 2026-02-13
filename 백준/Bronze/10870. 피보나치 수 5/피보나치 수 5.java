import java.io.*;
import java.util.*;

public class Main {
    
    //
    public static int fibo(int n) {
        // n이 10이야 10의 fibo를 구하려면? n-1이랑 n-2를 더해서 반환하면돼
        
        if (n == 0) return 0;
        if (n == 1) return 1;
        
        return fibo(n-1) + fibo(n-2);  
    } 
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = fibo(n);
        System.out.println(answer);
    }
    
}
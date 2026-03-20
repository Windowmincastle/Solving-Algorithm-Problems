import java.io.*;
import java.util.*;

public class Main {
    
    public static int convertInteger(String input) {
        return Integer.parseInt(input);
    }
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int a = convertInteger(br.readLine());
        int b = convertInteger(br.readLine());
        int c = convertInteger(br.readLine());
        
        long result = a * b * c;
        char[] resultChar = String.valueOf(result).toCharArray();
        
        int[] count = new int[10];
        
        for (char ch : resultChar) {
            count[ch - '0']++;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int v : count) {
            sb.append(v).append("\n");
        }
        
        System.out.println(sb.toString());
    }
    
}
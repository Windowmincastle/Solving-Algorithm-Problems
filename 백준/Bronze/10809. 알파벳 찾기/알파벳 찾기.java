import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        
        char[] words = {
            'a','b','c','d','e','f','g',
            'h','i','j','k','l','m','n',
            'o','p','q','r','s','t','u',
            'v','w','x','y','z'
        };
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input      = br.readLine();
        StringBuilder sb  = new StringBuilder();
        
        for(char c : words ){
            sb.append(input.indexOf(c)).append(" ");            
        }
        
        System.out.println(sb);
    }    
}

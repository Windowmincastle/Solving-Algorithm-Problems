import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String document = br.readLine();
        String word = br.readLine();
        
        int count = 0;
        int idx   = 0;
        
        while (true) {
            int found = document.indexOf(word,idx);
            if (found == -1) break;
            
            count++;
            idx = found + word.length();
        }
        System.out.println(count);
    }
    
}
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;

        for (int i=0; i<n; i++){

            Set<Character> set = new HashSet<>();
            String groupWord = br.readLine();
            boolean isGroup = true;
            
            char prevWord = groupWord.charAt(0);
            set.add(prevWord);
            
            for (int j=1; j<groupWord.length(); j++){
                
                char currentWord = groupWord.charAt(j);
                
                if (currentWord == prevWord) continue;    
                    
                if (set.contains(currentWord)) {
                    isGroup = false;
                    break;
                }
                
                set.add(currentWord);
                prevWord = currentWord;
            }
            
            if (isGroup) answer++;
        }
        
        System.out.println(answer);
    }
}

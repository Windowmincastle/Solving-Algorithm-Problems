import java.io.*;
import java.util.*;

public class Main{
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        
        Set<String> set = new HashSet<>();
        
        for (int i=0; i<S.length(); i++){
            
            for (int j=i; j<S.length(); j++){
                
                set.add(S.substring(i,j+1));
                
            }
            
        }
        
        int answer = set.size();
        System.out.println(answer);
    }
    
}
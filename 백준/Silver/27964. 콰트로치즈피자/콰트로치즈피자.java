import java.io.*;
import java.util.*;

public class Main{
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> cheese = new HashSet<>();
        
        int n = Integer.parseInt(br.readLine());
        String[] ary = br.readLine().split(" ");
        String CHEESE = "Cheese";
        
        for (int i=0; i<n; i++){
            if( ary[i].endsWith(CHEESE)){
                cheese.add(ary[i]);                
            }
        }
        
        // 주어지는 치즈와 피자를 만들 수 있는 갯수는 다르다
        String answer = (cheese.size() >= 4 ) ? "yummy" : "sad";
        
        System.out.println(answer);
    }
    
}
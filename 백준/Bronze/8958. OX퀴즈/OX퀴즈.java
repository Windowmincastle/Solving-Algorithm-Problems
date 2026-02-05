import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int TC = Integer.parseInt(br.readLine());
        
        for (int i=0; i<TC; i++) {
            
            int score = 1;
            int scoreSum = 0;
            char[] oxAry = br.readLine().toCharArray();
            
            for(int j=0; j<oxAry.length; j++) {
                
                if( oxAry[j] == 'O') {
                    scoreSum += score;
                    score++;
                } else {
                    score = 1;
                    continue;
                }
                
            }
            sb.append(scoreSum).append("\n");
        }
        
        System.out.println(sb.toString());
    }
    
}
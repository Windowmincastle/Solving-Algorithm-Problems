import java.io.*;
import java.util.*;

class Solution {

    
    public int[] solution(long n) {
        
        String temp = String.valueOf(n);
        String target = new StringBuilder(temp).reverse().toString();
        
        int[] answer = new int[target.length()];
        for (int i=0; i<target.length(); i++){
            answer[i] = target.charAt(i) - '0';
        }
        
        return answer;
    }
}
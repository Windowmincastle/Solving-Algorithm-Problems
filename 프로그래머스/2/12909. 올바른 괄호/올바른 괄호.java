import java.io.*;
import java.util.*;

class Solution {
    
    static boolean checkRight (String inputString) {
        
        boolean ans = false;
        int count = 0;
        
        
        
        for (int i=0; i<inputString.length(); i++){
            
            if (count < 0){
                break;
            }
            
            if ( inputString.charAt(i) == '('){
                count++;
            } else {
                count--;
            }
        }
        
        if ( count == 0){
            ans = true;
        } else {
            ans = false;
        }
        
        return ans;
   
        
    }
    
    boolean solution(String inputString) {

        boolean answer = checkRight(inputString);
        return answer;
    }
}
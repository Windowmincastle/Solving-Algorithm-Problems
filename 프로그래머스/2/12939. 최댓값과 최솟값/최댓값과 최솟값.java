import java.io.*;
import java.util.*;

class Solution {
    public String solution(String s) {
        
        String[] numbers = s.split(" ");
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for (String num : numbers){
            int value = Integer.parseInt(num);
            if(value < min) {
                min = value;
            }
            
            if ( value > max){
                max = value;
            }
        }
        
        return min + " " + max;
    
    }
}
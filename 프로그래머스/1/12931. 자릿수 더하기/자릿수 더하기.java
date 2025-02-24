import java.util.*;

public class Solution {
    public int solution(int n) {
        
        String input = String.valueOf(n);
        char[] ary = input.toCharArray();
        int total = 0;
        
        for (char a : ary ){
            
            total += Character.getNumericValue(a);    
            
        }
        
        return total;
        
    }
}
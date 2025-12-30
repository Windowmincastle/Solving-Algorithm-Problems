import java.util.*;
import java.io.*;

class Solution {
    
    public long solution(int price, int money, int count) {

        long answer = money;
        
        for (int i=0, j=1; i<count; i++,j++) {
            
            answer -= (price * j);
            
        }

        return answer > 0 ? 0 : Math.abs(answer);
    }
}
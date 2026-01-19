import java.util.*;

class Solution {

    public int getMaxSupport(int[] d, int budget) {
        
        int answer = 0;
        
        for (int i=0; i<d.length; i++) {
            
            if(d[i] > budget) return answer;
            
            budget -= d[i];
            answer++;
            
        }
        
        return answer;
    
    }
    
    public int solution(int[] d, int budget) {
        
        Arrays.sort(d);
        int answer = getMaxSupport(d,budget);
        
        return answer;
    }
}
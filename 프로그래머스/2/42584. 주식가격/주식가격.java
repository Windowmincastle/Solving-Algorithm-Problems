import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        
        int len = prices.length;
        int[] answer = new int[len];
        
        Stack<Integer> stack = new Stack<>();
        
        for (int i=0; i<len; i++){
            
        
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]){
                
                int prevIdx = stack.pop();
                answer[prevIdx] = i - prevIdx;
                
            }
            
            
            stack.push(i);
            
        }
        
        
        while(!stack.isEmpty()){
            
            int prevIdx = stack.pop();
            answer[prevIdx] = len - 1 -prevIdx;
            
        }
        
        return answer;
    }
}
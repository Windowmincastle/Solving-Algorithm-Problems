import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        
        Deque<Integer> q = new ArrayDeque<>();
        
        for (int num : arr ) {
            q.add(num);
        }
        
        List<Integer> list = new ArrayList<>();
        
        int current = q.poll();
        list.add(current);
        
        for (int num : q ) {
            
            if (current != q.peek()) {
                
                current = q.poll();
                list.add(current);
            } else {
                q.remove();    
            }
        }
        
        
        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
        

        return answer;
    
        
    }
}
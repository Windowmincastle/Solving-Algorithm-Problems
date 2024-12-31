import java.util.*;

class Solution {
    
    public int solution(int k, int[] tangerine) {
    
        Map<Integer,Integer> countMap = new HashMap<>();
        
        for (int size : tangerine) {
            countMap.put(size, countMap.getOrDefault(size,0) + 1);
        }
        
        List<Integer> counts = new ArrayList<>(countMap.values());
        counts.sort(Collections.reverseOrder());
        
        int total = 0;
        int types = 0;
        
        for (int count : counts){
            total += count;
            types++;
            
            if (total >= k ){
                break;
            }
        }
        
        
        return types;
    }
}
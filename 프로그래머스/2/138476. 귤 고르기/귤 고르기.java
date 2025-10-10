import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Map<Integer,Integer> map = new HashMap<>();

        for (int num : tangerine ){
            map.put(num,map.getOrDefault(num,0) + 1 );
        }
        
        List<Integer> counts = new ArrayList<>(map.values());
        counts.sort(Collections.reverseOrder());
        
        int remaining = k;
        int types = 0;
        
        for (int count : counts ){
            
            remaining -= count;
            types++;
            
            if (remaining <= 0) break;
        }
        
        answer = types;
        
        return answer;

    }

}


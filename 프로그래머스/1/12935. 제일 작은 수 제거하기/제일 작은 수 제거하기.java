import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        
        int[] answer = new int[arr.length - 1];
        
        int minValue = Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<arr.length; i++) {
            
            list.add(arr[i]);
            
            if ( arr[i] < minValue ) {
                minValue = arr[i];
            }
        }
        
        // 최소값을 구했고, arr에서 제거하기
        list.remove(Integer.valueOf(minValue));
        
        if (list.size() == 1) {
            answer = new int[1];
            answer[0] = -1;
        
        } else if (list.isEmpty()) {
            answer = new int[1];
            answer[0] = -1;
        }
        else {
            answer = list.stream().mapToInt(Integer::intValue).toArray();
        }
        
        return answer;
    }
}
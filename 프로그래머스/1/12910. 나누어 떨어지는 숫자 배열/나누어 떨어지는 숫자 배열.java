import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        // arr은 자연수를 담은 배열.
        // 정수 i랑 j에 대해 i랑 j가 같지 않으면 arr[i]랑 arr[j]랑 같지않다.
        // divisor는 자연수다.
        // array는 길이 1 이상인 배열이다.
                
        List<Integer> list = new ArrayList<>();
        
        for (int i=0; i<arr.length; i++) {
            
            if (arr[i] % divisor == 0 ) {
                list.add(arr[i]);
            }
            
        }
        
        int[] answer = {-1};
        
        if (list.isEmpty()) {
            return answer;
        } else {
            answer = list.stream().sorted().mapToInt(Integer::intValue).toArray();
        }
        
        return answer;
    }
}
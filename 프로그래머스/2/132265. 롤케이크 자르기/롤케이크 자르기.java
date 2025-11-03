import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int n = topping.length;
        
        int[] leftCount = new int[n];
        int[] rightCount = new int[n];
        
        // 왼쪽 토핑 종류 수 계산
        Set<Integer> leftSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            leftSet.add(topping[i]);
            leftCount[i] = leftSet.size();
        }
        
        // 오른쪽 토핑 종류 수 계산
        Set<Integer> rightSet = new HashSet<>();
        for (int i = n - 1; i >= 0; i--) {
            rightSet.add(topping[i]);
            rightCount[i] = rightSet.size();
        }
        
        // 공평하게 나누는 지점 세기
        int answer = 0;
        for (int i = 0; i < n - 1; i++) {
            if (leftCount[i] == rightCount[i + 1]) {
                answer++;
            }
        }
        
        return answer;
    }
}

import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int n = topping.length;

        // 철수와 동생이 가진 토핑의 종류 개수를 저장하는 배열
        int[] leftUniqueCount = new int[n];  
        int[] rightUniqueCount = new int[n];

        Set<Integer> leftSet = new HashSet<>();
        Set<Integer> rightSet = new HashSet<>();

        // 왼쪽에서 오른쪽으로 철수의 토핑 종류 개수 계산
        for (int i = 0; i < n; i++) {
            leftSet.add(topping[i]);
            leftUniqueCount[i] = leftSet.size();
        }

        // 오른쪽에서 왼쪽으로 동생의 토핑 종류 개수 계산
        for (int i = n - 1; i > 0; i--) {
            rightSet.add(topping[i]);
            rightUniqueCount[i] = rightSet.size();
        }

        // 공평하게 나눌 수 있는 지점 찾기
        for (int i = 0; i < n - 1; i++) {
            if (leftUniqueCount[i] == rightUniqueCount[i + 1]) {
                answer++;
            }
        }

        return answer;
    }
}

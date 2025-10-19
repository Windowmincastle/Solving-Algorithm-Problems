import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int n = elements.length;
        int[] arr = new int[2 * n];

        // 배열을 두 번 이어붙여 원형 수열처럼 만듦
        for (int i = 0; i < n; i++) {
            arr[i] = elements[i];
            arr[i + n] = elements[i];
        }

        Set<Integer> sumSet = new HashSet<>();

        // 길이가 1부터 n까지인 연속 부분 수열의 합 계산
        for (int len = 1; len <= n; len++) {
            for (int start = 0; start < n; start++) {
                int sum = 0;
                for (int k = start; k < start + len; k++) {
                    sum += arr[k];
                }
                sumSet.add(sum);
            }
        }

        return sumSet.size();
    }
}

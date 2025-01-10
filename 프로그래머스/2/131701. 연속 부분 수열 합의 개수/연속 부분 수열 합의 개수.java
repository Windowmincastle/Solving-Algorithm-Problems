import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] elements) {
        int n = elements.length;
        Set<Integer> sums = new HashSet<>();
        
        // 배열을 두 배로 확장하여 원형 수열 처리
        int[] extended = new int[n * 2];
        for (int i = 0; i < n; i++) {
            extended[i] = elements[i];
            extended[i + n] = elements[i];
        }
        
        // 투포인터로 연속 부분 수열 합 계산
        for (int length = 1; length <= n; length++) { // 부분 수열 길이
            int sum = 0;
            // 초기 합 계산
            for (int i = 0; i < length; i++) {
                sum += extended[i];
            }
            sums.add(sum); // 첫 번째 합 추가
            
            // 슬라이딩 윈도우로 나머지 합 계산
            for (int start = 1; start < n; start++) {
                sum = sum - extended[start - 1] + extended[start + length - 1];
                sums.add(sum); // 중복 제거하며 추가
            }
        }
        
        return sums.size();
    }
}

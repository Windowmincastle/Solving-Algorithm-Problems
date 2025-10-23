import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations); // 오름차순 정렬
        int n = citations.length;
        
        for (int i = 0; i < n; i++) {
            int h = n - i; // 현재 논문 이상으로 인용된 논문 수
            if (citations[i] >= h) {
                return h;
            }
        }
        return 0;
    }
}

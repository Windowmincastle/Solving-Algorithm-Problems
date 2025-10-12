class Solution {
    public int[] solution(int[] sequence, int k) {
        int left = 0, right = 0;
        int sum = sequence[0];
        
        int bestLeft = 0;
        int bestRight = 0;
        int minLen = Integer.MAX_VALUE;
        
        while (right < sequence.length) {
            if (sum == k) {
                int len = right - left;
                if (len < minLen) {
                    minLen = len;
                    bestLeft = left;
                    bestRight = right;
                }
                // 구간을 줄여서 다음 경우 탐색
                sum -= sequence[left];
                left++;
            } else if (sum < k) {
                right++;
                if (right < sequence.length)
                    sum += sequence[right];
            } else { // sum > k
                sum -= sequence[left];
                left++;
            }
        }
        
        return new int[]{bestLeft, bestRight};
    }
}

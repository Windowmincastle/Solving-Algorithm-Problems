public class Solution {
    public int solution(int n) {
        int ans = 0;

        while (n > 0) {
            // 홀수라면 점프 (배터리 사용 +1)
            if (n % 2 == 1) {
                ans++;
                n -= 1;
            }
            // 짝수라면 순간이동
            n /= 2;
        }

        return ans;
    }
}

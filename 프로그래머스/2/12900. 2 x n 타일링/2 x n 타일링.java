class Solution {
    public int solution(int n) {
        // 모듈러 연산에 사용할 값
        final int MOD = 1_000_000_007;
        
        // n은 1 이상 자연수(최대 60,000)라고 가정
        // 2×n 크기의 바닥을 2×1 타일로 채우는 경우의 수:
        // dp[n] = dp[n-1] + dp[n-2]
        // 이유: 맨 오른쪽 끝에서
        // 1) 세로로 타일 놓으면, 남은 부분은 2×(n-1) → dp[n-1]
        // 2) 가로로 2개를 쌓아놓듯 놓으면, 남은 부분은 2×(n-2) → dp[n-2]
        //
        // 초기값:
        // dp[1] = 1  (2×1 바닥: 세로 한 개만 놓는 방법)
        // dp[2] = 2  (2×2 바닥: (세로+세로) 또는 (가로 두 개: 위아래))
        
        if (n == 1) {
            return 1;
        }
        // n >= 2 인 경우
        // prev2 = dp[i-2], prev1 = dp[i-1]
        long prev2 = 1; // dp[1]
        long prev1 = 2; // dp[2]
        long curr = 0;
        
        // i가 3부터 n까지 반복하면서 dp 값 계산
        for (int i = 3; i <= n; i++) {
            curr = (prev1 + prev2) % MOD;
            // 다음 단계로 이동
            prev2 = prev1;
            prev1 = curr;
        }
        // 최종적으로 prev1이 dp[n]
        return (int) prev1;
    }
}

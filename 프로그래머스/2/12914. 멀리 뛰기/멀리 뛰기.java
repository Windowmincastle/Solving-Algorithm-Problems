import java.io.*;
import java.util.*;

class Solution {
    public long solution(int n) {
        
        // 1.dp 테이블 설정.
        int[] dp = new int[n+1];
        
        /// 2. 초기값 설정
        dp[1] = 1; // 1칸을 가는 방법은 1가지
        if ( n > 1 ) {
            dp[2] = 2; // 2칸을 가는 방법은 2가지
        }
        
        // 점화식 dp[n] = dp[n-1] + dp[n-2]
        for (int i = 3; i<= n; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 1234567 ;
        }
        
        return dp[n];
        
    }
}
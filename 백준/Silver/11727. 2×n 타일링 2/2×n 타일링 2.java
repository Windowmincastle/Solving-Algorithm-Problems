import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int MOD = 10007;

        // dp[i]: 2×i 타일링 방법의 수 (mod 10007)
        int[] dp = new int[n + 1];

        if (n >= 1) dp[1] = 1;
        if (n >= 2) dp[2] = 3;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % MOD;
        }

        System.out.println(dp[n]);
    }
}

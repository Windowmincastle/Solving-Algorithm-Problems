import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] price = new int[N+1];
        for (int i = 1; i <= N; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N+1];
        dp[0] = 0;
        for (int i = 1; i <= N; i++) {
            int best = 0;
            for (int j = 1; j <= i; j++) {
                best = Math.max(best, price[j] + dp[i - j]);
            }
            dp[i] = best;
        }

        System.out.println(dp[N]);
    }
}

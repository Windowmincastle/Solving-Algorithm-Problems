import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] dp = new int[1000002];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            dp[start]++;
            dp[end + 1]--; //end에는 예약을 못한다.
        }
        for (int i = 1; i < 1000001; i++) {
            dp[i] += dp[i - 1]; //누적합
        }
        StringBuilder sb = new StringBuilder();
        int Q = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            int num = Integer.parseInt(st.nextToken());
            sb.append(dp[num]).append("\n");
        }
        System.out.print(sb);
    }
}
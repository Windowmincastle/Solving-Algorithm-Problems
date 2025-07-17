import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 빠른 입력을 위해 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        
        // 상담 일정과 보수를 저장할 배열 (1-based)
        int[] T = new int[N + 1];
        int[] P = new int[N + 1];
        
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());  // 상담 기간
            P[i] = Integer.parseInt(st.nextToken());  // 상담 보수
        }
        
        // dp[i]: i일째부터 퇴사일까지 얻을 수 있는 최대 이익
        int[] dp = new int[N + 2];  
        // dp[N+1] = 0 으로 초기화되어 있으며, dp 배열도 0으로 초기화됨
        
        // 뒤에서부터 계산
        for (int i = N; i >= 1; i--) {
            int nextDay = i + T[i];  // 이 상담을 끝내는 날 다음날
            // 상담을 할 수 있는 경우
            if (nextDay <= N + 1) {
                // 상담 선택 vs 미선택 중 더 큰 값
                dp[i] = Math.max(P[i] + dp[nextDay], dp[i + 1]);
            } else {
                // 기간이 초과되면 상담 불가 -> 건너뛰기
                dp[i] = dp[i + 1];
            }
        }
        
        // 결과 출력
        System.out.println(dp[1]);
    }
}

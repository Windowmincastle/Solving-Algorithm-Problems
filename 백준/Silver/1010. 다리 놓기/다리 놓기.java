import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static final int MAX = 30;
    static long[][] comb = new long[MAX+1][MAX+1];

    public static void main(String[] args) throws IOException {
        // 1) 파스칼 삼각형으로 조합 테이블 초기화
        for (int n = 0; n <= MAX; n++) {
            comb[n][0] = comb[n][n] = 1;
            for (int k = 1; k < n; k++) {
                comb[n][k] = comb[n-1][k-1] + comb[n-1][k];
            }
        }

        // 2) 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());  // 서쪽 사이트 수
            int M = Integer.parseInt(st.nextToken());  // 동쪽 사이트 수
            // 3) 정답: M개 중 N개를 고르는 조합
            sb.append(comb[M][N]).append('\n');
        }
        System.out.print(sb);
    }
}

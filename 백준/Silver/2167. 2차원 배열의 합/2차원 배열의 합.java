import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 첫 번째 줄 입력
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 2차원 배열 선언 및 입력 (1-based indexing)
        int[][] ary = new int[n + 1][m + 1];  // 편의를 위해 1-based indexing 사용
        
        for (int i = 1; i <= n; i++) { // 1부터 시작
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= m; j++) { // 1부터 시작
                ary[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 누적합 배열 선언 및 초기화
        int[][] prefixSum = new int[n + 1][m + 1];

        // prefixSum 배열 계산 (1-based indexing)
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                prefixSum[i][j] = ary[i][j] + prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1];
            }
        }

        // 쿼리 입력
        int k = Integer.parseInt(br.readLine());

        // 쿼리 처리
        for (int q = 0; q < k; q++) {
            st = new StringTokenizer(br.readLine());

            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 원하는 영역의 합 계산
            int result = prefixSum[x][y] - prefixSum[i - 1][y] - prefixSum[x][j - 1] + prefixSum[i - 1][j - 1];

            // 결과 출력
            sb.append(result).append("\n");
        }

        // 결과 출력
        System.out.print(sb);
    }
}

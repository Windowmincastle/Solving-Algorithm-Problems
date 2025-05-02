import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력을 빠르게 받기 위한 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 배열 크기
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N + 1][M + 1]; // 1-based index
        int[][] prefixSum = new int[N + 1][M + 1]; // 누적합 배열

        // 배열 입력 받기
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                // 누적합 계산
                prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1]
                                - prefixSum[i - 1][j - 1] + arr[i][j];
            }
        }

        // 쿼리 수
        int K = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 쿼리 처리
        for (int q = 0; q < K; q++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int sum = prefixSum[x][y] - prefixSum[i - 1][y] - prefixSum[x][j - 1] + prefixSum[i - 1][j - 1];
            sb.append(sum).append("\n");
        }

        // 출력
        System.out.print(sb);
    }
}

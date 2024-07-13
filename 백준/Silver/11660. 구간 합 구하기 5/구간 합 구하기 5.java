import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        int[][] ary = new int[N + 1][N + 1];
        int[][] sum = new int[N + 1][N + 1];  // 누적 합 배열
        
        // 배열 초기화
        for (int i = 1; i <= N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 1; j <= N; j++) {
                ary[i][j] = Integer.parseInt(input[j - 1]);
                sum[i][j] = ary[i][j] + sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
            }
        }

        // 쿼리 처리
        for (int i = 0; i < M; i++) {
            String[] ip = br.readLine().split(" ");
            int curX = Integer.parseInt(ip[0]);
            int curY = Integer.parseInt(ip[1]);
            int targetX = Integer.parseInt(ip[2]);
            int targetY = Integer.parseInt(ip[3]);

            // 구간 합 계산
            int result = sum[targetX][targetY] - sum[curX - 1][targetY] - sum[targetX][curY - 1] + sum[curX - 1][curY - 1];
            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }
}

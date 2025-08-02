import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 첫째 줄: N, M
        String[] dims = br.readLine().split(" ");
        int n = Integer.parseInt(dims[0]);
        int m = Integer.parseInt(dims[1]);

        // 배열 입력
        int[][] ary = readArray(br, n, m);

        // 질의 개수 읽기
        int k = Integer.parseInt(br.readLine());

        // 질의 처리 및 결과 쌓기
        processQueries(br, sb, ary, k);

        // 결과 출력
        System.out.print(sb.toString());
    }

    /**
     * N×M 정수 배열을 읽어 반환한다.
     */
    private static int[][] readArray(BufferedReader br, int n, int m) throws IOException {
        int[][] array = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] parts = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                array[i][j] = Integer.parseInt(parts[j]);
            }
        }
        return array;
    }

    /**
     * K번의 질의를 읽어 (i,j)-(x,y) 구간 합을 계산하고 sb에 한 줄씩 추가한다.
     */
    private static void processQueries(BufferedReader br, StringBuilder sb, int[][] ary, int k) throws IOException {
        for (int q = 0; q < k; q++) {
            String[] parts = br.readLine().split(" ");
            int i = Integer.parseInt(parts[0]) - 1;
            int j = Integer.parseInt(parts[1]) - 1;
            int x = Integer.parseInt(parts[2]) - 1;
            int y = Integer.parseInt(parts[3]) - 1;

            int sum = 0;
            for (int r = i; r <= x; r++) {
                for (int c = j; c <= y; c++) {
                    sum += ary[r][c];
                }
            }
            sb.append(sum).append('\n');
        }
    }
}

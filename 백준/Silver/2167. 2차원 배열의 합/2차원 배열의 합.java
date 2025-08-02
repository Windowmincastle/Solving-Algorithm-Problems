import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 1) N, M 읽기
        String[] parts = br.readLine().split(" ");
        int n = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);

        // 2) N×M 배열 입력
        int[][] ary = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                ary[i][j] = Integer.parseInt(row[j]);
            }
        }

        // 3) 질의 개수 K 읽기
        int k = Integer.parseInt(br.readLine());

        // 4) K번 동안 (i, j)~(x, y) 합 구해서 sb에 추가
        for (int q = 0; q < k; q++) {
            String[] qry = br.readLine().split(" ");
            int i = Integer.parseInt(qry[0]);
            int j = Integer.parseInt(qry[1]);
            int x = Integer.parseInt(qry[2]);
            int y = Integer.parseInt(qry[3]);

            int sum = 0;
            for (int r = i - 1; r <= x - 1; r++) {
                for (int c = j - 1; c <= y - 1; c++) {
                    sum += ary[r][c];
                }
            }
            sb.append(sum).append('\n');
        }

        // 5) 결과 출력
        System.out.print(sb);
    }
}

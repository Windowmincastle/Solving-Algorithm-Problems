import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 빠른 입출력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        
        // 사진 밝기 저장 + 2D 누적합 배열 (1-based indexing)
        long[][] sum = new long[R+1][C+1];
        
        // 원본 입력을 받으며 바로 누적합 전처리
        for (int i = 1; i <= R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= C; j++) {
                int val = Integer.parseInt(st.nextToken());
                sum[i][j] = sum[i-1][j] + sum[i][j-1]
                          - sum[i-1][j-1] + val;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        // 각 질의마다 O(1)로 구간합과 평균 계산
        for (int qi = 0; qi < Q; qi++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            
            long regionSum = sum[r2][c2]
                             - sum[r1-1][c2]
                             - sum[r2][c1-1]
                             + sum[r1-1][c1-1];
            
            int area = (r2 - r1 + 1) * (c2 - c1 + 1);
            sb.append(regionSum / area).append('\n');
        }
        
        // 결과 출력
        System.out.print(sb.toString());
    }
}

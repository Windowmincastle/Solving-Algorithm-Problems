import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); // 종이 개수
        int M = Integer.parseInt(st.nextToken()); // 허용되는 최대 종이 개수
        int[][] grid = new int[101][101]; // 1-based 좌표이므로 101×101 사용

        // 종이 정보를 읽어서 grid에 적용
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            // 종이가 덮은 부분을 1씩 증가
            for (int x = x1; x <= x2; x++) {
                for (int y = y1; y <= y2; y++) {
                    grid[x][y]++;
                }
            }
        }

        // M개 이하로 덮인 칸만 세기
        int visibleCount = 0;
        for (int x = 1; x <= 100; x++) {
            for (int y = 1; y <= 100; y++) {
                if (grid[x][y] > M) {
                    visibleCount++;
                }
            }
        }

        System.out.println(visibleCount);
    }
}

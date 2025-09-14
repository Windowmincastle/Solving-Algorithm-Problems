import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken()); // 가로 길이 (x)
            int N = Integer.parseInt(st.nextToken()); // 세로 길이 (y)
            int K = Integer.parseInt(st.nextToken()); // 배추 개수

            boolean[][] map = new boolean[N][M]; // map[row(y)][col(x)]

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = true;
            }

            int worms = 0;
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    if (map[r][c]) {
                        worms++;
                        // BFS로 연결된 배추들 방문 처리
                        Queue<int[]> q = new LinkedList<>();
                        q.offer(new int[]{r, c});
                        map[r][c] = false;

                        while (!q.isEmpty()) {
                            int[] cur = q.poll();
                            int cr = cur[0], cc = cur[1];
                            for (int d = 0; d < 4; d++) {
                                int nr = cr + dr[d];
                                int nc = cc + dc[d];
                                if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc]) {
                                    map[nr][nc] = false;
                                    q.offer(new int[]{nr, nc});
                                }
                            }
                        }
                    }
                }
            }

            sb.append(worms).append('\n');
        }

        System.out.print(sb.toString());
    }
}

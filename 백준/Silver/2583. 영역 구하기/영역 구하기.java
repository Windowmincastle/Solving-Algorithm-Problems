import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static int M, N, K;
    static boolean[][] filled;
    static boolean[][] visited;
    // 4방 탐색 (상, 하, 좌, 우)
    static final int[] dx = {0, 0, -1, 1};
    static final int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        filled = new boolean[M][N];
        visited = new boolean[M][N];

        // 1) 직사각형 영역 채우기
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int y = y1; y < y2; y++) {
                for (int x = x1; x < x2; x++) {
                    filled[y][x] = true;
                }
            }
        }

        // 2) 빈 영역 찾기 (BFS)
        List<Integer> areas = new ArrayList<>();
        for (int y = 0; y < M; y++) {
            for (int x = 0; x < N; x++) {
                if (!filled[y][x] && !visited[y][x]) {
                    areas.add(bfs(y, x));
                }
            }
        }

        // 3) 결과 정렬 및 출력
        Collections.sort(areas);
        StringBuilder sb = new StringBuilder();
        sb.append(areas.size()).append('\n');
        for (int a : areas) {
            sb.append(a).append(' ');
        }
        System.out.println(sb.toString().trim());
    }

    // (startY, startX)에서 BFS를 수행하여 연결된 빈 칸의 개수(넓이)를 반환
    static int bfs(int startY, int startX) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{startY, startX});
        visited[startY][startX] = true;
        int area = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int y = cur[0], x = cur[1];
            area++;

            for (int dir = 0; dir < 4; dir++) {
                int ny = y + dy[dir];
                int nx = x + dx[dir];
                if (ny < 0 || ny >= M || nx < 0 || nx >= N) continue;
                if (filled[ny][nx] || visited[ny][nx]) continue;

                visited[ny][nx] = true;
                queue.offer(new int[]{ny, nx});
            }
        }
        return area;
    }
}

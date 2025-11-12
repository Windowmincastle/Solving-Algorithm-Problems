import java.util.*;

class Solution {
    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int solution(int[][] maps) {
        int n = maps.length;        // 행 개수
        int m = maps[0].length;     // 열 개수

        // 이동 방향 (상, 하, 좌, 우)
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        boolean[][] visited = new boolean[n][m];
        Queue<Point> queue = new LinkedList<>();

        // 시작점 (0,0)
        queue.add(new Point(0, 0));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            // 현재 위치에서 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                // 맵 범위 벗어나면 무시
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                // 벽이거나 이미 방문한 곳이면 무시
                if (maps[nx][ny] == 0 || visited[nx][ny]) continue;

                // 이동 가능 → 거리 갱신 + 방문 표시
                maps[nx][ny] = maps[now.x][now.y] + 1;
                visited[nx][ny] = true;
                queue.add(new Point(nx, ny));
            }
        }

        // 도착지에 도달했으면 거리 리턴, 아니면 -1
        return (maps[n - 1][m - 1] > 1) ? maps[n - 1][m - 1] : -1;
    }
}

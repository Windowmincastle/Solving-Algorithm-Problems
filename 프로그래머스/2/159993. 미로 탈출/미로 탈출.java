import java.util.*;

public class Solution {
    private static final int[] DX = {-1, 1, 0, 0};
    private static final int[] DY = {0, 0, -1, 1};

    public int solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();
        char[][] grid = new char[n][m];

        int sx = -1, sy = -1;
        int lx = -1, ly = -1;
        int ex = -1, ey = -1;

        for (int i = 0; i < n; i++) {
            String row = maps[i];
            for (int j = 0; j < m; j++) {
                grid[i][j] = row.charAt(j);
                if (grid[i][j] == 'S') { sx = i; sy = j; }
                else if (grid[i][j] == 'L') { lx = i; ly = j; }
                else if (grid[i][j] == 'E') { ex = i; ey = j; }
            }
        }

        // S -> L
        int d1 = bfs(grid, sx, sy, lx, ly);
        if (d1 == -1) return -1;

        // L -> E
        int d2 = bfs(grid, lx, ly, ex, ey);
        if (d2 == -1) return -1;

        return d1 + d2;
    }

    // BFS to compute shortest moves from (sx,sy) to (tx,ty). Returns -1 if unreachable.
    private int bfs(char[][] grid, int sx, int sy, int tx, int ty) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dist = new int[n][m];
        for (int[] row : dist) Arrays.fill(row, -1);

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {sx, sy});
        dist[sx][sy] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            if (x == tx && y == ty) return dist[x][y];

            for (int k = 0; k < 4; k++) {
                int nx = x + DX[k];
                int ny = y + DY[k];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (dist[nx][ny] != -1) continue;
                if (grid[nx][ny] == 'X') continue; // 벽 불가
                // S, L, E, O 모두 통과 가능하므로 추가 검사 불필요
                dist[nx][ny] = dist[x][y] + 1;
                q.add(new int[] {nx, ny});
            }
        }
        return -1; // 목적지에 도달하지 못함
    }
}

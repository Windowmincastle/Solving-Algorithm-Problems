import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String cmd = br.readLine();

        // 방향: 0=북, 1=동, 2=남, 3=서
        int dir = 2; // 처음은 남쪽
        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};

        int x = 0, y = 0;

        // 방문한 좌표 저장
        Set<String> visited = new HashSet<>();
        visited.add(x + "," + y);

        int minX = 0, maxX = 0;
        int minY = 0, maxY = 0;

        for (char c : cmd.toCharArray()) {
            if (c == 'L') {
                dir = (dir + 3) % 4;
            } else if (c == 'R') {
                dir = (dir + 1) % 4;
            } else if (c == 'F') {
                x += dx[dir];
                y += dy[dir];
                visited.add(x + "," + y);

                minX = Math.min(minX, x);
                maxX = Math.max(maxX, x);
                minY = Math.min(minY, y);
                maxY = Math.max(maxY, y);
            }
        }

        int rows = maxY - minY + 1;
        int cols = maxX - minX + 1;

        char[][] map = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            Arrays.fill(map[i], '#');
        }

        for (String s : visited) {
            String[] p = s.split(",");
            int vx = Integer.parseInt(p[0]);
            int vy = Integer.parseInt(p[1]);

            int row = vy - minY;
            int col = vx - minX;

            map[row][col] = '.';
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            sb.append(map[i]).append('\n');
        }

        System.out.print(sb);
    }
}

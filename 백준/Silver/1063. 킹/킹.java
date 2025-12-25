import java.io.*;
import java.util.*;

public class Main {

    static class Pos {
        int x, y;
        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // 이동 명령에 따른 방향 벡터
    static Map<String, int[]> moveMap = new HashMap<>();

    static {
        moveMap.put("R",  new int[]{1, 0});
        moveMap.put("L",  new int[]{-1, 0});
        moveMap.put("B",  new int[]{0, -1});
        moveMap.put("T",  new int[]{0, 1});
        moveMap.put("RT", new int[]{1, 1});
        moveMap.put("LT", new int[]{-1, 1});
        moveMap.put("RB", new int[]{1, -1});
        moveMap.put("LB", new int[]{-1, -1});
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Pos king = parsePos(st.nextToken());
        Pos stone = parsePos(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            String cmd = br.readLine();
            int[] d = moveMap.get(cmd);

            int nx = king.x + d[0];
            int ny = king.y + d[1];

            // 킹이 체스판 밖이면 무시
            if (!isIn(nx, ny)) continue;

            // 돌과 충돌하는 경우
            if (nx == stone.x && ny == stone.y) {
                int sx = stone.x + d[0];
                int sy = stone.y + d[1];

                // 돌이 체스판 밖이면 전체 이동 무시
                if (!isIn(sx, sy)) continue;

                // 돌 이동
                stone.x = sx;
                stone.y = sy;
            }

            // 킹 이동
            king.x = nx;
            king.y = ny;
        }

        System.out.println(formatPos(king));
        System.out.println(formatPos(stone));
    }

    // 문자열 좌표 → Pos
    static Pos parsePos(String s) {
        int x = s.charAt(0) - 'A';
        int y = s.charAt(1) - '1';
        return new Pos(x, y);
    }

    // Pos → 문자열 좌표
    static String formatPos(Pos p) {
        return "" + (char)(p.x + 'A') + (char)(p.y + '1');
    }

    // 체스판 범위 확인
    static boolean isIn(int x, int y) {
        return x >= 0 && x < 8 && y >= 0 && y < 8;
    }
}

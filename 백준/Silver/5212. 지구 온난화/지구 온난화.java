import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int R, C;
    static char[][] map;
    static char[][] next;

    // 상하좌우
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        next = new char[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        // 1. 50년 후 상태 계산
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (map[r][c] == 'X') {
                    int sea = 0;

                    for (int d = 0; d < 4; d++) {
                        int nr = r + dr[d];
                        int nc = c + dc[d];

                        if (nr < 0 || nr >= R || nc < 0 || nc >= C) {
                            sea++; // 지도 밖은 바다
                        } else if (map[nr][nc] == '.') {
                            sea++;
                        }
                    }

                    if (sea >= 3) next[r][c] = '.';
                    else next[r][c] = 'X';
                } else {
                    next[r][c] = '.';
                }
            }
        }

        // 2. 출력 범위 계산
        int minR = R, maxR = 0, minC = C, maxC = 0;

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (next[r][c] == 'X') {
                    minR = Math.min(minR, r);
                    maxR = Math.max(maxR, r);
                    minC = Math.min(minC, c);
                    maxC = Math.max(maxC, c);
                }
            }
        }

        // 3. 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int r = minR; r <= maxR; r++) {
            for (int c = minC; c <= maxC; c++) {
                sb.append(next[r][c]);
            }
            sb.append('\n');
        }

        System.out.print(sb.toString());
    }
}

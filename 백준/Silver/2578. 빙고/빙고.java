import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean[][] marked = new boolean[5][5];
    static int[][] pos = new int[26][2]; // 숫자 -> (row, col)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 빙고판 입력
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());
                pos[num][0] = i;
                pos[num][1] = j;
            }
        }

        int callCount = 0;

        // 사회자가 부르는 수 처리
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());
                callCount++;

                int r = pos[num][0];
                int c = pos[num][1];
                marked[r][c] = true;

                if (countBingo() >= 3) {
                    System.out.println(callCount);
                    return;
                }
            }
        }
    }

    static int countBingo() {
        int bingo = 0;

        // 가로
        for (int i = 0; i < 5; i++) {
            boolean ok = true;
            for (int j = 0; j < 5; j++) {
                if (!marked[i][j]) {
                    ok = false;
                    break;
                }
            }
            if (ok) bingo++;
        }

        // 세로
        for (int j = 0; j < 5; j++) {
            boolean ok = true;
            for (int i = 0; i < 5; i++) {
                if (!marked[i][j]) {
                    ok = false;
                    break;
                }
            }
            if (ok) bingo++;
        }

        // 대각선 (좌상 → 우하)
        boolean ok = true;
        for (int i = 0; i < 5; i++) {
            if (!marked[i][i]) {
                ok = false;
                break;
            }
        }
        if (ok) bingo++;

        // 대각선 (우상 → 좌하)
        ok = true;
        for (int i = 0; i < 5; i++) {
            if (!marked[i][4 - i]) {
                ok = false;
                break;
            }
        }
        if (ok) bingo++;

        return bingo;
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, M;
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        N = Integer.parseInt(nm[0]);
        M = Integer.parseInt(nm[1]);

        board = new char[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int answer = Integer.MAX_VALUE;

        // 모든 8x8 부분 보드에 대하여
        for (int si = 0; si <= N - 8; si++) {
            for (int sj = 0; sj <= M - 8; sj++) {
                // 두 가지 시작 색상(‘W’ 또는 ‘B’)으로 칠했을 때의 최소 리페인트 수 계산
                answer = Math.min(answer, countRepaints(si, sj, 'W'));
                answer = Math.min(answer, countRepaints(si, sj, 'B'));
            }
        }

        System.out.println(answer);
    }

    // si, sj: 8x8 블록의 시작 좌표
    // firstColor: (si, sj) 위치에 칠할 첫 색 (‘W’ 또는 ‘B’)
    private static int countRepaints(int si, int sj, char firstColor) {
        int repaint = 0;
        char expected = firstColor;

        for (int i = si; i < si + 8; i++) {
            for (int j = sj; j < sj + 8; j++) {
                if (board[i][j] != expected) {
                    repaint++;
                }
                // 다음 칸은 색이 번갈아가야 하므로 expected 토글
                expected = (expected == 'W') ? 'B' : 'W';
            }
            // 다음 줄의 첫 칸 색도 토글
            expected = (expected == 'W') ? 'B' : 'W';
        }

        return repaint;
    }
}

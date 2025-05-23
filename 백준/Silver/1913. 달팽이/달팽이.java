import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();

        int[][] board = new int[n][n];

        // 방향: 상, 우, 하, 좌
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int x = n / 2;
        int y = n / 2;
        board[x][y] = 1;

        int current = 2;
        int len = 1;
        int direction = 0;

        int tx = x, ty = y;

        while (current <= n * n) {
            for (int d = 0; d < 2; d++) { // 같은 길이로 두 방향 반복
                for (int i = 0; i < len; i++) {
                    x += dx[direction];
                    y += dy[direction];
                    if (x < 0 || y < 0 || x >= n || y >= n) continue;
                    board[x][y] = current;
                    if (current == target) {
                        tx = x;
                        ty = y;
                    }
                    current++;
                }
                direction = (direction + 1) % 4;
            }
            len++;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

        // 좌표는 1-based로 출력
        System.out.println((tx + 1) + " " + (ty + 1));
    }
}

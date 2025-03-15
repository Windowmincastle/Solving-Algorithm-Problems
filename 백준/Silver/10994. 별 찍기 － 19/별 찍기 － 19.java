import java.util.Scanner;

public class Main {
    static char[][] map;

    public static void draw(int size, int x, int y) {
        if (size == 1) {
            map[x][y] = '*';
            return;
        }

        int len = 4 * size - 3; // 현재 패턴의 한 변의 길이

        // 테두리 채우기
        for (int i = 0; i < len; i++) {
            map[x][y + i] = '*'; // 상단 가로줄
            map[x + len - 1][y + i] = '*'; // 하단 가로줄
            map[x + i][y] = '*'; // 좌측 세로줄
            map[x + i][y + len - 1] = '*'; // 우측 세로줄
        }

        // 내부 재귀 호출
        draw(size - 1, x + 2, y + 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int size = 4 * n - 3; // 전체 패턴의 크기
        map = new char[size][size];

        // 공백으로 초기화
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = ' ';
            }
        }

        // 별 그리기
        draw(n, 0, 0);

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(map[i]).append("\n");
        }
        System.out.print(sb);
    }
}

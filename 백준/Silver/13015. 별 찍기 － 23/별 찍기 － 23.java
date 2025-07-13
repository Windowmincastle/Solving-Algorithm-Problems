import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();

        int width = 4 * N - 3;           // 한 줄의 총 칸 수
        int outerGap = width - 2 * N;    // 첫 줄, 마지막 줄 사이의 공백 수

        StringBuilder sb = new StringBuilder();

        // 1) 맨 윗줄
        sb.append(repeat('*', N))
          .append(repeat(' ', outerGap))
          .append(repeat('*', N))
          .append('\n');

        // 2) 윗부분(2번째 줄 ~ N-1번째 줄)
        for (int i = 1; i <= N - 2; i++) {
            int gapBetween = outerGap - 2 * i;  // 내부 별그룹 사이 공백
            sb.append(repeat(' ', i))
              .append('*')
              .append(repeat(' ', N - 2))
              .append('*')
              .append(repeat(' ', gapBetween))
              .append('*')
              .append(repeat(' ', N - 2))
              .append('*')
              .append('\n');
        }

        // 3) 가운데 줄
        sb.append(repeat(' ', N - 1))
          .append('*')
          .append(repeat(' ', N - 2))
          .append('*')
          .append(repeat(' ', N - 2))
          .append('*')
          .append('\n');

        // 4) 아랫부분(위쪽 윗부분의 역순)
        for (int i = N - 2; i >= 1; i--) {
            int gapBetween = outerGap - 2 * i;
            sb.append(repeat(' ', i))
              .append('*')
              .append(repeat(' ', N - 2))
              .append('*')
              .append(repeat(' ', gapBetween))
              .append('*')
              .append(repeat(' ', N - 2))
              .append('*')
              .append('\n');
        }

        // 5) 맨 아랫줄 (맨 윗줄과 동일)
        if (N > 1) {
            sb.append(repeat('*', N))
              .append(repeat(' ', outerGap))
              .append(repeat('*', N))
              .append('\n');
        }

        System.out.print(sb.toString());
    }

    // char c를 count만큼 반복한 문자열 반환
    private static String repeat(char c, int count) {
        if (count <= 0) return "";
        StringBuilder sb = new StringBuilder(count);
        for (int i = 0; i < count; i++) {
            sb.append(c);
        }
        return sb.toString();
    }
}

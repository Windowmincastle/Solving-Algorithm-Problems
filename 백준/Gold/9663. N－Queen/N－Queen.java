import java.util.Scanner;

public class Main {

    static int n;
    static int ans;
    static int[] v1;
    static int[] v2;
    static int[] v3;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        ans = 0;
        v1 = new int[n]; // 열 체크 배열
        v2 = new int[2 * n]; // 좌측 대각선 체크 배열
        v3 = new int[2 * n]; // 우측 대각선 체크 배열

        // 첫 번째 행부터 퀸 배치 시작
        dfs(0);

        // 결과 출력
        System.out.println(ans);

        // 스캐너 닫기
       // sc.close();
    }

    // 퀸을 배치하는 함수
    static void dfs(int row) {
        // 모든 행에 퀸을 배치한 경우
        if (row == n) {
            // 유효한 배치의 수를 증가
            ans++;
            return;
        }

        // 현재 행의 각 열에 대해 퀸을 놓을 수 있는지 체크
        for (int col = 0; col < n; col++) {
            // 현재 열과 대각선에 퀸이 없는 경우
            if (v1[col] == 0 && v2[row + col] == 0 && v3[row - col + n] == 0) {
                // 퀸을 해당 위치에 놓음
                v1[col] = v2[row + col] = v3[row - col + n] = 1;

                // 다음 행으로 이동하여 퀸을 배치 시도
                dfs(row + 1);

                // 현재 위치에서 퀸을 제거 (백트래킹)
                v1[col] = v2[row + col] = v3[row - col + n] = 0;
            }
        }
    }
}

import java.util.Scanner;

public class Main {
    private static int N;
    private static int ans;
    private static int[] v1;
    private static int[] v2;
    private static int[] v3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        ans = 0;
        v1 = new int[N];
        v2 = new int[2 * N];
        v3 = new int[2 * N];

        dfs(0);

        System.out.println(ans);
        scanner.close();
    }

    private static void dfs(int n) {
        if (n == N) {  // N행까지 진행한 경우 경우의수 가능: 성공
            ans++;
            return;
        }

        for (int j = 0; j < N; j++) {
            if (v1[j] == 0 && v2[n + j] == 0 && v3[n - j + N] == 0) {  // 열/대각선 모두 Q없음
                v1[j] = v2[n + j] = v3[n - j + N] = 1;
                dfs(n + 1);
                v1[j] = v2[n + j] = v3[n - j + N] = 0;
            }
        }
    }
}

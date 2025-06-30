import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] A;
    static boolean[] used;
    static int[] perm;
    static int maxSum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        used = new boolean[N];
        perm = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 순열 생성 시작
        dfs(0);

        // 결과 출력
        System.out.println(maxSum);
    }

    // depth: 현재 perm에 채워진 개수
    private static void dfs(int depth) {
        if (depth == N) {
            // 완성된 순열의 차이 합 계산
            int sum = 0;
            for (int i = 0; i < N - 1; i++) {
                sum += Math.abs(perm[i] - perm[i + 1]);
            }
            maxSum = Math.max(maxSum, sum);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!used[i]) {
                used[i] = true;
                perm[depth] = A[i];
                dfs(depth + 1);
                used[i] = false;
            }
        }
    }
}

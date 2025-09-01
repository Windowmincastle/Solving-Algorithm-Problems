import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        int[] Ns = new int[T];
        int maxN = 0;
        for (int i = 0; i < T; i++) {
            Ns[i] = Integer.parseInt(br.readLine().trim());
            if (Ns[i] > maxN) maxN = Ns[i];
        }

        if (maxN < 1) maxN = 1; // 안전장치 (문제에서는 N>=1)

        // Euler's totient 계산 (sieve 방식)
        long[] phi = new long[maxN + 1];
        for (int i = 0; i <= maxN; i++) phi[i] = i;
        for (int i = 2; i <= maxN; i++) {
            if (phi[i] == i) { // i는 소수
                for (int j = i; j <= maxN; j += i) {
                    phi[j] -= phi[j] / i;
                }
            }
        }

        // 누적합
        long[] pref = new long[maxN + 1];
        for (int i = 1; i <= maxN; i++) pref[i] = pref[i - 1] + phi[i];

        // 각 테스트케이스에 대해 출력: 1 + 2 * sum_{i=1..N} phi(i)
        for (int i = 0; i < T; i++) {
            int n = Ns[i];
            long ans = 1 + 2 * pref[n];
            sb.append(ans).append('\n');
        }

        System.out.print(sb.toString());
    }
}

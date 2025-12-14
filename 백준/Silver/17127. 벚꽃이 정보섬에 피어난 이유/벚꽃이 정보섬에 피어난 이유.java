import java.io.*;
import java.util.*;

public class Main {

    static int[] A;
    static int N;

    static int product(int l, int r) {
        int res = 1;
        for (int i = l; i <= r; i++) {
            res *= A[i];
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;

        for (int i = 0; i < N - 3; i++) {
            for (int j = i + 1; j < N - 2; j++) {
                for (int k = j + 1; k < N - 1; k++) {
                    int sum =
                        product(0, i) +
                        product(i + 1, j) +
                        product(j + 1, k) +
                        product(k + 1, N - 1);

                    max = Math.max(max, sum);
                }
            }
        }

        System.out.println(max);
    }
}

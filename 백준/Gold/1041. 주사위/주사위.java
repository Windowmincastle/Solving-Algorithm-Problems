import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static long N;
    private static long oneFaceMin, twoFaceMin, threeFaceMin;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Long.parseLong(br.readLine());
        int[] dice = new int[6];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 6; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
        }

        // 마주보는 면 중 최소값을 계산
        long minAF = Math.min(dice[0], dice[5]);
        long minBE = Math.min(dice[1], dice[4]);
        long minCD = Math.min(dice[2], dice[3]);

        // 1, 2, 3면의 최소값 계산
        oneFaceMin = Math.min(Math.min(minAF, minBE), minCD);
        twoFaceMin = Math.min(minAF + minBE, Math.min(minAF + minCD, minBE + minCD));
        threeFaceMin = minAF + minBE + minCD;

        long sum = calculateMinSum(dice);

        bw.write(String.valueOf(sum));
        bw.flush();
        br.close();
        bw.close();
    }

    private static long calculateMinSum(int[] dice) {
        if (N == 1) {
            long sum = 0;
            long max = Integer.MIN_VALUE;
            for (int i = 0; i < 6; i++) {
                sum += dice[i];
                max = Math.max(max, dice[i]);
            }
            return sum - max;
        }

        // 주사위 면의 최소값 계산
        long oneFaceCount = (N - 2) * (N - 2) + 4 * (N - 2) * (N - 1);
        long twoFaceCount = 4 * (N - 1) + 4 * (N - 2);
        long threeFaceCount = 4;

        // 전체 최소값 계산
        return oneFaceMin * oneFaceCount + twoFaceMin * twoFaceCount + threeFaceMin * threeFaceCount;
    }
}

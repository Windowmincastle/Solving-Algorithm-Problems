

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        long X = Long.parseLong(input[0]);
        long Y = Long.parseLong(input[1]);

        long winRate = Y * 100 / X;

        if (winRate >= 99) {
            System.out.println(-1);
            return;
        }

        long start = 1;
        long end = X;
        long answer = -1;

        while (start <= end) {
            long mid = (start + end) / 2;
            long newWinRate = (Y + mid) * 100 / (X + mid);

            if (newWinRate > winRate) {
                answer = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(answer);
    }
}

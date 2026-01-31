import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());

        int diagonal = 0;
        int sum = 0;

        // 1. X가 속한 대각선 찾기
        while (sum < X) {
            diagonal++;
            sum += diagonal;
        }

        // 2. 대각선 내 위치
        int index = X - (sum - diagonal);

        int numerator, denominator;

        // 3. 지그재그 방향 결정
        if (diagonal % 2 == 0) {
            // 짝수 대각선
            numerator = index;
            denominator = diagonal - index + 1;
        } else {
            // 홀수 대각선
            numerator = diagonal - index + 1;
            denominator = index;
        }

        System.out.println(numerator + "/" + denominator);
    }
}

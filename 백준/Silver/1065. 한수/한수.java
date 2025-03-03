import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(countHanNumbers(N));
    }

    // 한수의 개수를 세는 메서드
    public static int countHanNumbers(int N) {
        if (N < 100) return N; // 1~99는 모두 한수이므로 N 그대로 반환

        int count = 99; // 1~99는 모두 한수
        for (int i = 100; i <= N; i++) {
            if (isHanNumber(i)) count++;
        }
        return count;
    }

    // 특정 숫자가 한수인지 판별하는 메서드
    public static boolean isHanNumber(int num) {
        int A = num / 100;         // 백의 자리
        int B = (num / 10) % 10;   // 십의 자리
        int C = num % 10;          // 일의 자리

        return (B - A) == (C - B); // 등차수열 여부 확인
    }
}

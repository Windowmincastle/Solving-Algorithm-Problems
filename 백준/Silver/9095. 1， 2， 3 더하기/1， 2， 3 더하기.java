import java.util.Scanner;

public class Main {

    // 최대 n은 10이므로 크기를 넉넉하게 11로 지정
    static int[] dp = new int[11];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 테스트 케이스 개수 입력
        int T = sc.nextInt();

        // 점화식 기반으로 미리 dp 배열을 채워둠 (Bottom-Up 방식)
        // dp[n] = n을 1, 2, 3의 합으로 나타내는 방법의 수

        // 초기값 설정
        dp[0] = 1; // 아무것도 선택하지 않는 경우 (편의상 1로 설정)
        dp[1] = 1; // 1 -> 1가지 (1)
        dp[2] = 2; // 1+1, 2
        dp[3] = 4; // 1+1+1, 1+2, 2+1, 3

        // 점화식: dp[n] = dp[n-1] + dp[n-2] + dp[n-3]
        for (int i = 4; i <= 10; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        // 각 테스트 케이스에 대해 결과 출력
        for (int t = 0; t < T; t++) {
            int n = sc.nextInt(); // n 입력
            System.out.println(dp[n]); // 미리 구한 dp 배열에서 결과 출력
        }

        sc.close();
    }
}

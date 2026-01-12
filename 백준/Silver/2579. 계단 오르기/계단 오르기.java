import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 계단의 개수

        int[] score = new int[n + 1];
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            score[i] = sc.nextInt();
        }

        // 초기값 설정
        dp[1] = score[1];
        
        // 계단이 1개인 경우 예외 처리
        if (n >= 2) {
            dp[2] = score[1] + score[2];
        }

        // 점화식을 이용한 DP 진행
        // i가 3부터 시작하므로 dp[i-3]을 위해 n=3 이상일 때 실행
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + score[i - 1]) + score[i];
        }

        System.out.println(dp[n]);
        sc.close();
    }
}
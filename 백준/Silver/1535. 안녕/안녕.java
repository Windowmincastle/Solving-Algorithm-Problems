import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 사람 수
        int[] L = new int[n]; // 체력 소모
        int[] J = new int[n]; // 기쁨 획득

        for (int i = 0; i < n; i++) {
            L[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            J[i] = sc.nextInt();
        }

        int[] dp = new int[101]; // dp[체력]: 해당 체력 소모 시 최대 기쁨

        for (int i = 0; i < n; i++) {
            for (int hp = 100; hp >= L[i]; hp--) {
                // 체력이 L[i] 이상일 때만 선택 가능
                dp[hp] = Math.max(dp[hp], dp[hp - L[i]] + J[i]);
            }
        }

        int maxJoy = 0;
        for (int i = 1; i < 100; i++) { // 체력이 1~99일 때만 가능 (100 이상은 죽음)
            maxJoy = Math.max(maxJoy, dp[i]);
        }

        System.out.println(maxJoy);
    }
}

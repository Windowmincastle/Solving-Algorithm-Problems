import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[][] ary = new int[n][5];
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                ary[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int maxScore = -1; // 전체 게임에서의 최고 점수
        int winner = 0;    // 우승자 번호

        for (int i = 0; i < n; i++) {
            int personalMax = 0; // i번째 사람의 최선 점수
            
            // 5장 중 3장을 고르는 모든 조합 (3중 for문)
            for (int a = 0; a < 3; a++) {
                for (int b = a + 1; b < 4; b++) {
                    for (int c = b + 1; c < 5; c++) {
                        int sum = ary[i][a] + ary[i][b] + ary[i][c];
                        int onesDigit = sum % 10; // 일의 자리 계산
                        
                        if (onesDigit > personalMax) {
                            personalMax = onesDigit;
                        }
                    }
                }
            }

            // 전체 우승자 조건 확인
            // 점수가 같으면 번호가 큰 사람이 이기므로 >= 조건을 사용
            if (personalMax >= maxScore) {
                maxScore = personalMax;
                winner = i + 1; // 인덱스는 0부터 시작하므로 번호는 +1
            }
        }

        System.out.println(winner);
    }
}
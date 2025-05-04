import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int winner = 0;    // 최종 승자 번호
        int bestDigit = -1;  // 최종 승자의 일의 자리 수
        
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] cards = new int[5];
            for (int j = 0; j < 5; j++) {
                cards[j] = Integer.parseInt(st.nextToken());
            }
            
            // 이 사람의 최대 일의 자리 수 계산
            int maxDigit = 0;
            for (int a = 0; a < 5; a++) {
                for (int b = a + 1; b < 5; b++) {
                    for (int c = b + 1; c < 5; c++) {
                        int sum = cards[a] + cards[b] + cards[c];
                        int digit = sum % 10;
                        if (digit > maxDigit) {
                            maxDigit = digit;
                        }
                    }
                }
            }
            
            // 비교: 더 크면 교체, 같으면 번호 큰 쪽으로 교체
            if (maxDigit > bestDigit || (maxDigit == bestDigit && i > winner)) {
                bestDigit = maxDigit;
                winner = i;
            }
        }
        
        System.out.println(winner);
    }
}

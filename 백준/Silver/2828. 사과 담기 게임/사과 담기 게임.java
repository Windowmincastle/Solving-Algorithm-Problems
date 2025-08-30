import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int J = Integer.parseInt(br.readLine().trim());

        int left = 1;          // 바구니의 왼쪽 끝
        int right = M;         // 바구니의 오른쪽 끝
        int moves = 0;         // 이동 거리 누적

        for (int i = 0; i < J; i++) {
            int x = Integer.parseInt(br.readLine().trim()); // 사과가 떨어지는 칸

            if (x < left) {
                // 왼쪽으로 이동
                int diff = left - x;
                moves += diff;
                left -= diff;
                right -= diff;
            } else if (x > right) {
                // 오른쪽으로 이동
                int diff = x - right;
                moves += diff;
                left += diff;
                right += diff;
            }
            // x가 [left, right] 안에 있으면 이동 없음
        }

        System.out.println(moves);
    }
}

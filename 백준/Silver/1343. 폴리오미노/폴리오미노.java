import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String board = br.readLine();

        StringBuilder result = new StringBuilder();
        int n = board.length();
        int i = 0;

        while (i < n) {

            // '.'이면 그대로 추가
            if (board.charAt(i) == '.') {
                result.append('.');
                i++;
                continue;
            }

            // 연속된 X의 개수 세기
            int count = 0;
            while (i < n && board.charAt(i) == 'X') {
                count++;
                i++;
            }

            // 홀수이면 덮을 수 없음
            if (count % 2 != 0) {
                System.out.println(-1);
                return;
            }

            // AAAA 최대한 채우기
            while (count >= 4) {
                result.append("AAAA");
                count -= 4;
            }

            // 남은 2칸은 BB
            if (count == 2) {
                result.append("BB");
            }
        }

        System.out.println(result);
    }
}

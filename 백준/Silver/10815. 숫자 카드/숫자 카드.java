import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        /*
5 = 상근이가 가지고 있는 숫자 카드의 개수 n
6 3 2 10 -10 = 5개의 숫자 카드 목록
8 = M개의 숫자 카드 목록이 몇개인가
10 9 -5 2 3 4 5 -10 = M개의 숫자 카드 목록
        */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int card = Integer.parseInt(st.nextToken());
            cnt.put(card, cnt.getOrDefault(card, 0) + 1);
        }

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            if (cnt.get(target) != null) {
                sb.append(1).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }

        System.out.println(sb);
    }
}

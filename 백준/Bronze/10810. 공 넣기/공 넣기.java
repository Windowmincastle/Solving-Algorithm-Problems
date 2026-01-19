import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 바구니 상태: 공 번호 하나만 저장하면 됨
        int[] basket = new int[N];

        for (int t = 0; t < M; t++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end   = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            // 1-based → 0-based 보정
            for (int i = start - 1; i <= end - 1; i++) {
                basket[i] = value;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(basket[i]).append(" ");
        }

        System.out.println(sb.toString());
    }
}

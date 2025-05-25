import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split(" ");
        int N = Integer.parseInt(parts[0]);
        int K = Integer.parseInt(parts[1]);
        char[] table = br.readLine().toCharArray();

        boolean[] eaten = new boolean[N];  // 햄버거 먹혔는지 체크
        int count = 0;

        for (int i = 0; i < N; i++) {
            if (table[i] == 'P') {
                // i-K ~ i+K 범위에서 햄버거 찾기
                int start = Math.max(0, i - K);
                int end = Math.min(N - 1, i + K);
                for (int j = start; j <= end; j++) {
                    if (table[j] == 'H' && !eaten[j]) {
                        eaten[j] = true;
                        count++;
                        break;
                    }
                }
            }
        }

        System.out.println(count);
    }
}

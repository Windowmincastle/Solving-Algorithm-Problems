import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        int len = arr[0].length();

        // k를 1부터 증가시키며 검사
        for (int k = 1; k <= len; k++) {
            Set<String> set = new HashSet<>();
            boolean unique = true;

            for (String s : arr) {
                String sub = s.substring(len - k); // 뒤에서 k자리
                if (!set.add(sub)) {
                    unique = false;
                    break;
                }
            }

            if (unique) {
                System.out.println(k);
                return;
            }
        }
    }
}
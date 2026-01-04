import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();

        int[] cnt = new int[26];
        for (char c : name.toCharArray()) {
            cnt[c - 'A']++;
        }

        int oddCount = 0;
        int oddIndex = -1;

        for (int i = 0; i < 26; i++) {
            if (cnt[i] % 2 == 1) {
                oddCount++;
                oddIndex = i;
            }
        }

        // 팰린드롬 불가능
        if (oddCount > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        StringBuilder left = new StringBuilder();

        // 사전순으로 왼쪽 절반 생성
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < cnt[i] / 2; j++) {
                left.append((char) ('A' + i));
            }
        }

        StringBuilder result = new StringBuilder();
        result.append(left);

        // 가운데 문자 (있는 경우)
        if (oddIndex != -1) {
            result.append((char) ('A' + oddIndex));
        }

        // 오른쪽 절반
        result.append(left.reverse());

        System.out.println(result.toString());
    }
}

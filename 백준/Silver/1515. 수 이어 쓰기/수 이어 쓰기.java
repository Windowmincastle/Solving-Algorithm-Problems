import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int idx = 0;     // s에서 현재 매칭해야 할 위치
        int num = 1;     // 1부터 시작

        while (idx < s.length()) {
            String current = String.valueOf(num);

            for (int i = 0; i < current.length(); i++) {
                if (idx < s.length() && current.charAt(i) == s.charAt(idx)) {
                    idx++;
                }
            }

            num++;
        }

        System.out.println(num - 1);
    }
}

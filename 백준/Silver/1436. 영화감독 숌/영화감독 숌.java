import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int cnt = 0;
        int num = 666; // 666부터 시작 (0부터 시작할 필요 없음)

        while (true) {
            if (String.valueOf(num).contains("666")) {
                cnt++;
                if (cnt == n) {
                    System.out.println(num);
                    break;
                }
            }
            num++; // num을 증가시켜야 다음 숫자를 검사할 수 있음
        }
    }
}

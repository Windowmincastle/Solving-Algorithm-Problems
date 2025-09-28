import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();

        // 변환 횟수 카운트
        int count = 0;

        // 이미 한 자리인 경우 (변환 안 함)
        if (s.length() == 1) {
            int v = s.charAt(0) - '0';
            System.out.println(0);
            System.out.println(v % 3 == 0 ? "YES" : "NO");
            return;
        }

        // 여러 자리면 반복해서 자리수 합을 구함
        while (s.length() > 1) {
            int sum = 0;
            for (int i = 0; i < s.length(); i++) {
                sum += s.charAt(i) - '0';
            }
            s = Integer.toString(sum);
            count++;
        }

        int finalDigit = s.charAt(0) - '0';
        System.out.println(count);
        System.out.println(finalDigit % 3 == 0 ? "YES" : "NO");
    }
}

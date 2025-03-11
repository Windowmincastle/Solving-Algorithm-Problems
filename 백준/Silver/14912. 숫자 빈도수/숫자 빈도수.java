import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        char d = input[1].charAt(0); // char로 변환

        int count = 0;
        for (int i = 1; i <= n; i++) {
            String numStr = String.valueOf(i); // 숫자를 문자열로 변환
            for (char c : numStr.toCharArray()) {
                if (c == d) count++;
            }
        }

        System.out.println(count);
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); // 세로
        int M = Integer.parseInt(input[1]); // 가로
        
        int result = 0;

        if (N == 1) {
            result = 1;
        } else if (N == 2) {
            result = Math.min(4, (M + 1) / 2);
        } else {
            if (M < 7) {
                result = Math.min(4, M);
            } else {
                result = M - 2;
            }
        }

        sb.append(result);
        System.out.println(sb);
    }
}

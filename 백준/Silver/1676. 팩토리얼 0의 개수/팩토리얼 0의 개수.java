import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int count = 0;
        int divisor = 5;
        while (divisor <= N) {
            count += N / divisor;
            divisor *= 5;
        }
        System.out.println(count);
    }
}

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String[] input = br.readLine().split(" ");
        int E = Integer.parseInt(input[0]);
        int S = Integer.parseInt(input[1]);
        int M = Integer.parseInt(input[2]);

        int year = 1;
        int e = 1, s = 1, m = 1;

        while (true) {
            if (e == E && s == S && m == M) {
                sb.append(year);
                break;
            }
            year++;
            e = (e % 15) + 1;
            s = (s % 28) + 1;
            m = (m % 19) + 1;
        }

        System.out.println(sb);
    }
}

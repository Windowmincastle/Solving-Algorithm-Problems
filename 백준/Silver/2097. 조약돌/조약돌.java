import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine().trim());
        
        long answer = Long.MAX_VALUE;
        int limit = (int) Math.sqrt(N);
        if (limit < 2) limit = 2;

        // iterate a = W+1 (>=2)
        for (int a = 2; a <= limit + 1; a++) {
            long b = (N + a - 1) / a; // ceil(N / a)
            if (b < 2) b = 2;
            long perimeter = 2 * ((a - 1) + (b - 1)); // 2*(W+H) where W=a-1, H=b-1
            if (perimeter < answer) answer = perimeter;
        }

        System.out.println(answer);
    }
}

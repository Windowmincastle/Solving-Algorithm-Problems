import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    private static final BufferedInputStream in = new BufferedInputStream(System.in);
    
    private static int nextInt() throws IOException {
        int c = in.read();
        while (c <= ' ') { // skip whitespace
            if (c == -1) return Integer.MIN_VALUE; // EOF guard (not expected here)
            c = in.read();
        }
        int sign = 1;
        if (c == '-') {
            sign = -1;
            c = in.read();
        }
        int val = 0;
        while (c > ' ') {
            val = val * 10 + (c - '0');
            c = in.read();
        }
        return val * sign;
    }

    public static void main(String[] args) throws Exception {
        int N = nextInt();
        int K = nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = nextInt();
        }
        Arrays.sort(arr);
        System.out.println(arr[K - 1]);
    }
}

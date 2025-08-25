import java.io.*;
import java.util.*;

public class Main {
    // 빠른 입력 전용 스캐너
    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream is) { this.in = is; }

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c, sign = 1, val = 0;
            // 공백 스킵
            do { c = read(); } while (c <= ' ' && c != -1);

            // 음수 처리
            if (c == '-') { sign = -1; c = read(); }

            // 숫자 읽기
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        StringBuilder out = new StringBuilder();

        int N = fs.nextInt();
        int[] prefix = new int[N + 1]; // prefix[0] = 0

        for (int i = 1; i <= N; i++) {
            prefix[i] = prefix[i - 1] + fs.nextInt();
        }

        int M = fs.nextInt();
        for (int q = 0; q < M; q++) {
            int i = fs.nextInt();
            int j = fs.nextInt();
            out.append(prefix[j] - prefix[i - 1]).append('\n');
        }

        System.out.print(out.toString());
    }
}

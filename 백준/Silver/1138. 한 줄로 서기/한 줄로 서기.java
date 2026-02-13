import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[N+1]; // 1..N 사용
        for (int i = 1; i <= N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> line = new ArrayList<>();
        for (int h = N; h >= 1; h--) {
            line.add(a[h], h); // 인덱스 a[h] 에 키 h 삽입
        }

        StringBuilder sb = new StringBuilder();
        for (int x : line) {
            sb.append(x).append(' ');
        }
        System.out.println(sb.toString().trim());
    }
}

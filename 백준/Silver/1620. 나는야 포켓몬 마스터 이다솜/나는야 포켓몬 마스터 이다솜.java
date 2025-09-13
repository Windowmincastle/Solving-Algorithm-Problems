import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] names = new String[N + 1];
        Map<String, Integer> map = new HashMap<>(N * 2);

        for (int i = 1; i <= N; i++) {
            String name = br.readLine().trim();
            names[i] = name;
            map.put(name, i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String q = br.readLine().trim();
            if (q.length() > 0 && Character.isDigit(q.charAt(0))) {
                int idx = Integer.parseInt(q);
                sb.append(names[idx]).append('\n');
            } else {
                sb.append(map.get(q)).append('\n');
            }
        }

        System.out.print(sb.toString());
    }
}

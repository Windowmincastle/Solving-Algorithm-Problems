import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] degree = new int[N + 1];

        // 간선 입력(트리이므로 N-1개). 입력 순서는 질의 t=2에서 사용되지만
        // 트리에서는 모든 간선이 단절선이므로 간선 저장은 필요없고 degree만 세면 된다.
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            degree[a]++;
            degree[b]++;
        }

        int Q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            if (t == 1) {
                // 정점 k가 단절점인지: degree[k] >= 2 -> yes
                sb.append(degree[k] >= 2 ? "yes" : "no").append('\n');
            } else {
                // 트리의 모든 간선은 단절선
                sb.append("yes").append('\n');
            }
        }

        System.out.print(sb.toString());
    }
}

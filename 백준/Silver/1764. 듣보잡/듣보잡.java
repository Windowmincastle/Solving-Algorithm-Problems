import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력을 빠르게 받기 위한 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 듣도 못한 사람 수(N)과 보도 못한 사람 수(M) 입력
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 듣도 못한 사람들을 저장할 HashSet
        Set<String> unheard = new HashSet<>();
        for (int i = 0; i < n; i++) {
            unheard.add(br.readLine());
        }

        // 교집합을 저장할 ArrayList
        List<String> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String name = br.readLine();
            if (unheard.contains(name)) {
                result.add(name);
            }
        }

        // 결과를 사전순으로 정렬
        Collections.sort(result);

        // 출력
        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append("\n");
        for (String name : result) {
            sb.append(name).append("\n");
        }
        System.out.print(sb);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N, M 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 집합 S
        HashSet<String> set = new HashSet<>();

        // N개의 문자열 저장
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        // 검사 문자열
        int count = 0;
        for (int i = 0; i < M; i++) {
            String target = br.readLine();
            if (set.contains(target)) {
                count++;
            }
        }

        // 결과 출력
        System.out.println(count);
    }
}

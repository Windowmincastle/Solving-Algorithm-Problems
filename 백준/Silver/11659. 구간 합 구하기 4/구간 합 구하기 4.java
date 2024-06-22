import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄 입력: N과 M
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 두 번째 줄 입력: N개의 수
        int[] array = new int[N + 1]; // 1-based index를 사용하기 위해 크기를 N+1로 설정
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        // 부분 합 배열 계산
        long[] prefixSum = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            prefixSum[i] = prefixSum[i - 1] + array[i];
        }

        // 쿼리 처리
        StringBuilder sb = new StringBuilder();
        for (int q = 0; q < M; q++) {
            st = new StringTokenizer(br.readLine(), " ");
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            long sum = prefixSum[j] - prefixSum[i - 1];
            sb.append(sum).append("\n");
        }

        // 결과 출력
        System.out.print(sb.toString());
    }
}

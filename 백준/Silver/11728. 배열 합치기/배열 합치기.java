import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력을 위한 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 출력 성능 향상을 위한 StringBuilder
        StringBuilder sb = new StringBuilder();

        // 첫 줄에서 N과 M 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 두 배열 A, B 생성
        int[] A = new int[N];
        int[] B = new int[M];

        // A 배열 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // B 배열 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        // 두 포인터를 이용해 정렬된 배열 합치기
        int i = 0, j = 0;
        while (i < N && j < M) {
            if (A[i] <= B[j]) {
                sb.append(A[i++]).append(" ");
            } else {
                sb.append(B[j++]).append(" ");
            }
        }

        // 남은 원소 처리
        while (i < N) {
            sb.append(A[i++]).append(" ");
        }
        while (j < M) {
            sb.append(B[j++]).append(" ");
        }

        // 결과 출력
        System.out.println(sb);
    }
}

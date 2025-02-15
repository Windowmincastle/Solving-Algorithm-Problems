import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // N 입력
        int N = Integer.parseInt(br.readLine());
        
        // 배열 A와 B 입력
        int[] A = new int[N];
        Integer[] B = new Integer[N]; // 내림차순 정렬을 위해 Integer 사용
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        
        // 배열 A는 오름차순 정렬
        Arrays.sort(A);
        
        // 배열 B는 내림차순 정렬
        Arrays.sort(B, Collections.reverseOrder());
        
        // S의 최솟값 계산
        int result = 0;
        for (int i = 0; i < N; i++) {
            result += A[i] * B[i];
        }
        
        // 결과 출력
        sb.append(result);
        System.out.println(sb);
    }
}

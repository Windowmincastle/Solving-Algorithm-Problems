import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력 처리
        int n = Integer.parseInt(br.readLine().trim());
        int m = Integer.parseInt(br.readLine().trim());
        
        int[] materials = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            materials[i] = Integer.parseInt(st.nextToken());
        }
        
        // 재료 번호 정렬
        Arrays.sort(materials);
        
        // 두 포인터 기법을 이용한 갑옷 개수 세기
        int answer = 0;
        int start = 0;
        int end = n - 1;
        
        while (start < end) {
            int sum = materials[start] + materials[end];
            if (sum == m) {
                answer++;
                start++;
                end--;
            } else if (sum < m) {
                start++;
            } else { // sum > m
                end--;
            }
        }
        
        // 결과 출력
        System.out.println(answer);
    }
}

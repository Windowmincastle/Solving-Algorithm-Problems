import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력을 위한 BufferedReader 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 출력을 위한 StringBuilder 초기화
        StringBuilder sb = new StringBuilder();
        
        // 1. 스위치 개수 입력
        int switchCount = Integer.parseInt(br.readLine());
        // 2. 스위치 상태 입력
        int[] switches = new int[switchCount + 1]; // 1-based index 사용을 위해 크기 +1
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= switchCount; i++) {
            switches[i] = Integer.parseInt(st.nextToken());
        }
        
        // 3. 학생 수 입력
        int studentCount = Integer.parseInt(br.readLine());
        
        // 4. 학생의 성별과 숫자 입력 및 처리
        for (int i = 0; i < studentCount; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken()); // 성별: 1(남학생), 2(여학생)
            int number = Integer.parseInt(st.nextToken()); // 받은 숫자
            
            if (gender == 1) { // 남학생 처리
                for (int j = number; j <= switchCount; j += number) {
                    switches[j] = switches[j] ^ 1; // 스위치 상태 토글 (0->1, 1->0)
                }
            } else if (gender == 2) { // 여학생 처리
                int left = number;
                int right = number;
                while (left > 0 && right <= switchCount && switches[left] == switches[right]) {
                    left--;
                    right++;
                }
                left++;
                right--;
                // 구간 내 모든 스위치 상태를 토글
                for (int j = left; j <= right; j++) {
                    switches[j] = switches[j] ^ 1;
                }
            }
        }
        
        // 5. 출력: 20개씩 줄바꿈 처리
        for (int i = 1; i <= switchCount; i++) {
            sb.append(switches[i]).append(" ");
            if (i % 20 == 0) sb.append("\n"); // 20개 출력 후 줄바꿈
        }
        
        // 최종 결과 출력
        System.out.print(sb.toString());
    }
}

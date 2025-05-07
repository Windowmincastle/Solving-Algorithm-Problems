import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1. BufferedReader를 통해 한 줄씩 빠르게 입력을 읽어들인다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 2. 첫 번째 줄에서 학기 전체 시간을 분 단위로 파싱한다.
        int N = Integer.parseInt(br.readLine());
        
        // 3. 최대 N개의 과제가 쌓일 수 있으므로, 점수와 남은 시간을 저장할 스택용 배열을 선언.
        int[] scoreStack = new int[N];   // 각 과제의 만점
        int[] timeStack  = new int[N];   // 각 과제의 남은 시간
        int   top        = 0;            // 스택 포인터: 현재 스택의 크기이자 다음 삽입 위치
        long  totalScore = 0L;           // 완료된 과제들의 누적 점수
        
        // 4. 1분 단위로 학기가 진행됨.
        for (int minute = 0; minute < N; minute++) {
            // 4-1. 해당 분에 들어온 과제 정보 한 줄 읽기
            String line = br.readLine();
            
            // 4-2. 새로운 과제가 주어졌다면 (문자열의 첫 글자가 '1'인 경우)
            if (line.charAt(0) == '1') {
                // "1 A T" 형태로 주어지므로 split하여 A(점수), T(소요시간)를 파싱
                String[] parts = line.split(" ");
                int A = Integer.parseInt(parts[1]);  // 과제 만점
                int T = Integer.parseInt(parts[2]);  // 과제 소요시간
                
                // 4-3. 스택에 푸시: 가장 최근 과제가 top 위치에 저장
                scoreStack[top] = A;
                timeStack[top]  = T;
                top++;  // 스택 크기 증가
            }
            // 4-4. 현재 진행 중인 과제(스택 최상단)가 있으면, 1분을 사용하여 작업
            if (top > 0) {
                // 1분 경과: 남은 시간 1 감소
                timeStack[top - 1]--;
                
                // 시간이 모두 소진되면 과제 완료 처리
                if (timeStack[top - 1] == 0) {
                    // 완료 과제 점수를 누적 합에 더하고,
                    totalScore += scoreStack[top - 1];
                    // 스택에서 pop: top을 하나 줄여 이전 과제로 복귀
                    top--;
                }
            }
            // 4-5. 이 시점에서 다음 분으로 넘어가기 전까지 모든 처리 완료됨.
        }
        
        // 5. 모든 분이 지나간 후 누적된 점수를 출력.
        // StringBuilder에 담아 한 번에 출력하면 I/O 오버헤드를 최소화할 수 있다.
        StringBuilder sb = new StringBuilder();
        sb.append(totalScore).append('\n');
        System.out.print(sb);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    
    // 풍선 정보를 저장할 클래스 정의
    static class Balloon {
        int index;  // 풍선의 번호
        int value;  // 풍선 안에 적힌 값
        
        public Balloon(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
    
    public static void main(String[] args) throws IOException {
        // BufferedReader를 사용하여 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 풍선의 개수 N 입력 받기
        int N = Integer.parseInt(br.readLine());
        
        // 풍선 안에 적힌 값들 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 풍선 정보를 저장할 덱 생성
        Deque<Balloon> balloons = new ArrayDeque<>();
        
        // 각 풍선의 번호와 값을 덱에 저장
        for (int i = 1; i <= N; i++) {
            int value = Integer.parseInt(st.nextToken());
            balloons.add(new Balloon(i, value));
        }
        
        // 결과를 저장할 StringBuilder 생성
        StringBuilder sb = new StringBuilder();
        
        // 첫 번째 풍선 처리
        Balloon current = balloons.pollFirst();  // 첫 번째 풍선 꺼내기
        sb.append(current.index).append(" ");    // 결과에 풍선 번호 추가
        
        // 모든 풍선이 터질 때까지 반복
        while (!balloons.isEmpty()) {
            int move = current.value;  // 현재 풍선에 적힌 값
            
            if (move > 0) {
                // 양수인 경우 오른쪽으로 이동
                for (int i = 0; i < move - 1; i++) {
                    // 덱의 앞에서 꺼내서 뒤로 넣기 (오른쪽으로 이동)
                    balloons.addLast(balloons.pollFirst());
                }
                // 다음 터뜨릴 풍선
                current = balloons.pollFirst();
            } else {
                // 음수인 경우 왼쪽으로 이동
                for (int i = 0; i < Math.abs(move); i++) {
                    // 덱의 뒤에서 꺼내서 앞으로 넣기 (왼쪽으로 이동)
                    balloons.addFirst(balloons.pollLast());
                }
                // 다음 터뜨릴 풍선
                current = balloons.pollFirst();
            }
            
            // 결과에 풍선 번호 추가
            sb.append(current.index).append(" ");
        }
        
        // 결과 출력
        System.out.println(sb);
    }
}

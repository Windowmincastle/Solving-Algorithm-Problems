import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 두 문자열 A와 B 입력 받기
        String[] input = br.readLine().split(" ");
        String A = input[0];
        String B = input[1];

        int minDiff = Integer.MAX_VALUE; // 차이의 최소값을 저장 (처음엔 아주 큰 값으로 설정)

        // B 안에서 A를 맞출 수 있는 모든 시작 위치 확인
        // 예: A 길이가 3, B 길이가 5면 시작 위치는 0, 1, 2 총 3개 가능
        for (int start = 0; start <= B.length() - A.length(); start++) {
            int diff = 0; // 현재 위치에서의 문자 차이 개수

            // A와 B의 해당 부분 비교
            for (int i = 0; i < A.length(); i++) {
                if (A.charAt(i) != B.charAt(start + i)) {
                    diff++; // 서로 다르면 차이 개수 증가
                }
            }

            // 최소 차이 갱신
            minDiff = Math.min(minDiff, diff);
        }

        // 결과 출력
        System.out.println(minDiff);
    }
}

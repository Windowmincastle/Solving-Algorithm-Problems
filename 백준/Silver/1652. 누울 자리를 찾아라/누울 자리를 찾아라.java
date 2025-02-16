import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        char[][] room = new char[N][N];
        
        // 방 정보 입력받기
        for (int i = 0; i < N; i++) {
            room[i] = br.readLine().toCharArray();
        }
        
        int horizontal = 0;
        int vertical = 0;
        
        // 가로 검사
        for (int i = 0; i < N; i++) {
            int count = 0;
            for (int j = 0; j < N; j++) {
                if (room[i][j] == '.') {
                    count++;
                } else {
                    if (count >= 2) {
                        horizontal++;
                    }
                    count = 0;
                }
            }
            // 마지막 칸까지 체크
            if (count >= 2) {
                horizontal++;
            }
        }
        
        // 세로 검사
        for (int j = 0; j < N; j++) {
            int count = 0;
            for (int i = 0; i < N; i++) {
                if (room[i][j] == '.') {
                    count++;
                } else {
                    if (count >= 2) {
                        vertical++;
                    }
                    count = 0;
                }
            }
            // 마지막 칸까지 체크
            if (count >= 2) {
                vertical++;
            }
        }
        
        // 결과 출력
        StringBuilder sb = new StringBuilder();
        sb.append(horizontal).append(" ").append(vertical);
        System.out.println(sb.toString());
    }
}

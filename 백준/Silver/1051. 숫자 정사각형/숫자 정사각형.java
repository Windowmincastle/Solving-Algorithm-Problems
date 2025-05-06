import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] board = new char[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int maxArea = 1;  // 최소 크기는 1
        int maxSide = Math.min(N, M);

        // side: 정사각형 한 변의 길이
        for (int side = 2; side <= maxSide; side++) {
            for (int i = 0; i + side - 1 < N; i++) {
                for (int j = 0; j + side - 1 < M; j++) {
                    char c = board[i][j];
                    // 네 꼭짓점이 같은지 확인
                    if (board[i][j + side - 1] == c
                     && board[i + side - 1][j] == c
                     && board[i + side - 1][j + side - 1] == c) {
                        maxArea = Math.max(maxArea, side * side);
                    }
                }
            }
        }

        // 출력
        StringBuilder sb = new StringBuilder();
        sb.append(maxArea);
        System.out.println(sb.toString());
    }
}

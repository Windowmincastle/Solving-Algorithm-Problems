import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // 5x5 빙고판과 숫자 위치를 저장하는 Map
        int[][] bingoBoard = new int[5][5];
        Map<Integer, int[]> positionMap = new HashMap<>();
        
        // 빙고판 입력
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());
                bingoBoard[i][j] = num;
                positionMap.put(num, new int[]{i, j});
            }
        }

        // 사회자가 부르는 숫자 입력
        int[] calledNumbers = new int[25];
        int index = 0;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                calledNumbers[index++] = Integer.parseInt(st.nextToken());
            }
        }

        // 빙고 체크 배열 (가로, 세로, 대각선)
        int[] rowCheck = new int[5];
        int[] colCheck = new int[5];
        int diag1 = 0, diag2 = 0; // 대각선

        // 사회자가 부르는 숫자 순서대로 처리
        for (int callIndex = 0; callIndex < 25; callIndex++) {
            int calledNum = calledNumbers[callIndex];
            int[] pos = positionMap.get(calledNum);
            int r = pos[0], c = pos[1];

            // 가로, 세로, 대각선 카운트 업데이트
            rowCheck[r]++;
            colCheck[c]++;
            if (r == c) diag1++;
            if (r + c == 4) diag2++;

            // 현재 빙고 개수 계산
            int bingoCount = 0;
            for (int i = 0; i < 5; i++) {
                if (rowCheck[i] == 5) bingoCount++;
                if (colCheck[i] == 5) bingoCount++;
            }
            if (diag1 == 5) bingoCount++;
            if (diag2 == 5) bingoCount++;

            // 빙고가 3개 이상이면 출력 후 종료
            if (bingoCount >= 3) {
                System.out.println(callIndex + 1);
                return;
            }
        }
    }
}

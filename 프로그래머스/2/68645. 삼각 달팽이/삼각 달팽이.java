import java.util.Arrays;

public class Solution {
    public int[] solution(int n) {
        // n x n 배열을 사용해 삼각형 영역에만 값을 채운다.
        int[][] triangle = new int[n][n];
        int x = 0, y = 0;          // 현재 위치 (행, 열)
        int num = 1;               // 채워 넣을 숫자
        int size = n;              // 현재 한 사이클(아래-오른쪽-대각위)에서 이동할 길이

        while (size > 0) {
            // 아래로 size번 이동하며 채운다.
            for (int i = 0; i < size; i++) {
                triangle[x++][y] = num++;
            }
            x--; y++; size--;      // 위치 보정 및 다음 단계 길이 감소
            if (size <= 0) break;

            // 오른쪽으로 size번 이동하며 채운다.
            for (int i = 0; i < size; i++) {
                triangle[x][y++] = num++;
            }
            y -= 2; x--; size--;   // 위치 보정 및 다음 단계 길이 감소
            if (size <= 0) break;

            // 위-왼쪽(대각선)으로 size번 이동하며 채운다.
            for (int i = 0; i < size; i++) {
                triangle[x--][y--] = num++;
            }
            x += 2; y++; size--;   // 위치 보정
        }

        // 삼각형 영역(각 행의 0..i 열) 순서대로 1차원 배열로 반환
        int total = n * (n + 1) / 2;
        int[] answer = new int[total];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[idx++] = triangle[i][j];
            }
        }
        return answer;
    }

    // 테스트용 main (예시 출력)
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(4))); // [1,2,9,3,10,8,4,5,6,7]
        System.out.println(Arrays.toString(s.solution(5))); // [1,2,12,3,13,11,4,14,15,10,5,6,7,8,9]
        System.out.println(Arrays.toString(s.solution(6))); // [1,2,15,3,16,14,4,17,21,13,5,18,19,20,12,6,7,8,9,10,11]
    }
}

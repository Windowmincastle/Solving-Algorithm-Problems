class Solution {
    public int[] solution(int n) {
        int[][] arr = new int[n][n];
        
        int num = 1;
        int r = -1, c = 0;
        
        for (int i = 0; i < n; i++) { 
            for (int j = i; j < n; j++) {
                // 방향 결정
                if (i % 3 == 0) {
                    // 아래로 이동
                    r++;
                } else if (i % 3 == 1) {
                    // 오른쪽으로 이동
                    c++;
                } else {
                    // 왼쪽 위로 이동
                    r--;
                    c--;
                }
                arr[r][c] = num++;
            }
        }
        
        // 결과 배열 크기
        int size = n * (n + 1) / 2;
        int[] answer = new int[size];
        
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[idx++] = arr[i][j];
            }
        }
        
        return answer;
    }
}

class Solution {
    int solution(int[][] land) {

        // 이전 행에서의 최대값들을 저장하는 배열
        int[] dp = land[0]; // 첫 행 그대로 초기화

        for (int i = 1; i < land.length; i++) {

            int[] current = new int[4];

            for (int col = 0; col < 4; col++) {
                int max = 0;

                // 이전 행에서 같은 열(col)을 제외한 열들 중 최고값 찾기
                for (int prev = 0; prev < 4; prev++) {
                    if (prev != col) {
                        max = Math.max(max, dp[prev]);
                    }
                }

                // 현재 칸의 점수 + 이전 행의 최댓값
                current[col] = land[i][col] + max;
            }

            dp = current; // 다음 행을 위해 갱신
        }

        // 마지막 행에서 가능한 최고값이 정답
        int answer = 0;
        for (int value : dp) answer = Math.max(answer, value);

        return answer;
    }
}

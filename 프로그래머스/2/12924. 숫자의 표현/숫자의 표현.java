class Solution {
    public int solution(int n) {
        int answer = 0;

        // 시작 숫자를 1부터 n까지 돌림
        for (int start = 1; start <= n; start++) {
            int sum = 0;
            // start부터 연속해서 더해가기
            for (int num = start; num <= n; num++) {
                sum += num;
                if (sum == n) {   // 합이 정확히 n이 되면 방법 1개 찾음
                    answer++;
                    break;       // 더 이상 볼 필요 없음 → 다음 start로
                }
                if (sum > n) {   // 합이 n을 넘으면 중단
                    break;
                }
            }
        }

        return answer;
    }
}

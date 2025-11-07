class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }

    private int dfs(int[] numbers, int target, int depth, int sum) {
        // 모든 숫자를 다 사용했을 때
        if (depth == numbers.length) {
            // 타겟 넘버와 합이 같으면 1가지 방법으로 카운트
            return sum == target ? 1 : 0;
        }

        // 현재 숫자를 더하는 경우 + 빼는 경우 둘 다 탐색
        int plus = dfs(numbers, target, depth + 1, sum + numbers[depth]);
        int minus = dfs(numbers, target, depth + 1, sum - numbers[depth]);

        // 두 가지 경우의 수 합산
        return plus + minus;
    }
}

class Solution {
    static boolean solution(String input) {

        int answer = 0;

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (ch == '(') {
                answer++;
            } else if (ch == ')') {
                answer--;
            }

            // 진행 중에 count가 0 미만이 되면 올바르지 않은 문자열
            if (answer < 0) {
                return false;
            }
        }

        // 모든 문자열을 확인한 후 count가 0이어야 올바른 문자열
        return answer == 0;
    }
}
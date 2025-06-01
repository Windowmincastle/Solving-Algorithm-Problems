public class Solution {
    public int solution(int storey) {
        int count = 0;

        while (storey > 0) {
            int digit = storey % 10;
            int next = (storey / 10) % 10;

            if (digit > 5) {
                // ex) 7, 8, 9면 올리는 게 이득
                count += 10 - digit;
                storey += 10; // 다음 자리수에 carry 발생
            } else if (digit == 5 && next >= 5) {
                // 5일 경우, 다음 자리가 5 이상이면 올리는 게 이득
                count += 5;
                storey += 10;
            } else {
                // 내리는 게 이득
                count += digit;
            }

            storey /= 10;
        }

        return count;
    }
}

class Solution {
    public int solution(int n, int k) {
        // 1. n을 k진수로 변환
        String converted = Integer.toString(n, k);

        // 2. 0을 기준으로 분리
        String[] parts = converted.split("0");

        int count = 0;

        // 3. 각 부분이 소수인지 판별
        for (String part : parts) {
            if (part.isEmpty()) continue; // 빈 문자열 무시

            long num = Long.parseLong(part); // int로는 부족할 수 있음
            if (isPrime(num)) {
                count++;
            }
        }

        return count;
    }

    // 4. 소수 판별 함수
    private boolean isPrime(long num) {
        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;

        for (long i = 3; i * i <= num; i += 2) {
            if (num % i == 0) return false;
        }
        return true;
    }
}

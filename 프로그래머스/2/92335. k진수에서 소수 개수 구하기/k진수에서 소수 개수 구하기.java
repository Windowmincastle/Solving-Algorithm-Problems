public class Solution {
    public int solution(int n, int k) {
        String baseK = toBaseK(n, k);
        String[] parts = baseK.split("0");
        int count = 0;
        for (String part : parts) {
            if (part.isEmpty()) continue;
            long num = Long.parseLong(part); // part는 0을 포함하지 않음
            if (isPrime(num)) count++;
        }
        return count;
    }
    
    // n을 k진수 문자열로 변환 (최상위 자리부터)
    private String toBaseK(int n, int k) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % k);
            n /= k;
        }
        if (sb.length() == 0) return "0";
        return sb.reverse().toString();
    }
    
    // 소수 판별 (효율적으로)
    private boolean isPrime(long x) {
        if (x < 2) return false;
        if (x == 2) return true;
        if (x % 2 == 0) return false;
        long limit = (long) Math.sqrt(x);
        for (long i = 3; i <= limit; i += 2) {
            if (x % i == 0) return false;
        }
        return true;
    }
}

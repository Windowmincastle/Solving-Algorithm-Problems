import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int gcdA = arrayA[0];
        for (int i = 1; i < arrayA.length; i++) {
            gcdA = gcd(gcdA, arrayA[i]);
        }

        int gcdB = arrayB[0];
        for (int i = 1; i < arrayB.length; i++) {
            gcdB = gcd(gcdB, arrayB[i]);
        }

        // 각 GCD의 약수 중 조건에 맞는 가장 큰 수 반환
        int resultA = getMaxValidDivisor(gcdA, arrayB);
        int resultB = getMaxValidDivisor(gcdB, arrayA);

        return Math.max(resultA, resultB);
    }

    // 조건을 만족하는 최대 약수 찾기
    private int getMaxValidDivisor(int gcd, int[] otherArray) {
        List<Integer> divisors = getDivisors(gcd);
        // 큰 값부터 검사
        Collections.sort(divisors, Collections.reverseOrder());

        for (int divisor : divisors) {
            boolean valid = true;
            for (int num : otherArray) {
                if (num % divisor == 0) {
                    valid = false;
                    break;
                }
            }
            if (valid) return divisor;
        }

        return 0;
    }

    // 약수 구하기
    private List<Integer> getDivisors(int num) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                result.add(i);
                if (i != num / i) result.add(num / i);
            }
        }
        return result;
    }

    // 최대공약수 (GCD)
    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}

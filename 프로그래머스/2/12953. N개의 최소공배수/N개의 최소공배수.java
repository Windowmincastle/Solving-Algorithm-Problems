class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];

        for (int i = 1; i < arr.length; i++) {
            answer = lcm(answer, arr[i]);
        }

        return answer;
    }

    // 최대공약수(GCD) 구하기 - 유클리드 호제법
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    // 최소공배수(LCM) 구하기
    private int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}

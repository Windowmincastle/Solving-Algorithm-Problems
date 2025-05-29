class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder seq = new StringBuilder();
        int num = 0;
        // 충분한 길이(최소 m*t)가 될 때까지 n진수 문자열을 이어붙인다.
        while (seq.length() < m * t) {
            seq.append(toBaseN(num++, n));
        }
        
        StringBuilder answer = new StringBuilder();
        // 게임 참가자 수 m 중, 튜브의 순서 p에 해당하는 문자만 골라 t개를 뽑는다.
        for (int i = 0; i < t; i++) {
            answer.append(seq.charAt(p - 1 + i * m));
        }
        return answer.toString();
    }
    
    // 10진수 num을 n진수 문자열로 변환 (10~15 → 'A'~'F')
    private String toBaseN(int num, int base) {
        if (num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            int rem = num % base;
            if (rem < 10) {
                sb.append((char)('0' + rem));
            } else {
                sb.append((char)('A' + (rem - 10)));
            }
            num /= base;
        }
        return sb.reverse().toString();
    }
}

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder total = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        
        int num = 0; // 0부터 시작
        
        // t개를 얻으려면 m명씩 돌아가므로 충분히 길어야 한다.
        // 최소 t * m 글자 이상 필요함.
        while (total.length() < t * m) {
            // n진수로 변환 후 대문자로
            total.append(Integer.toString(num++, n).toUpperCase());
        }
        
        // 튜브는 p번째(1-indexed) → 인덱스는 p-1
        for (int i = p - 1; i < total.length() && answer.length() < t; i += m) {
            answer.append(total.charAt(i));
        }
        
        return answer.toString();
    }
}

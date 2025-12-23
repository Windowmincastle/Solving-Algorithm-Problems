class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        
        if (a == b) return a;
        
        int swap = 0;
        if (a > b) {
            swap = b;
            b = a;
            a = swap;
        }
        
        for (int i=a; i<=b; i++) {
            answer += i;
        }
        
        return answer;
    }
}
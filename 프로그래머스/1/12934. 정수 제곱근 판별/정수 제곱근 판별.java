class Solution {
    public long solution(long n) {

        long x = (long) Math.sqrt(n);
        
        // 제곱해서 다시 n이 되는지 확인
        if(x * x == n) {
            return (x+1) * (x+1);
        } else {
            return -1;
        }
    }
}
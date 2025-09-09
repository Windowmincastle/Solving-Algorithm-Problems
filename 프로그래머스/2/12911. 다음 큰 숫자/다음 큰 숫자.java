class Solution {
    public int solution(int n) {
        int oneCount = Integer.bitCount(n); // n의 1의 개수
        
        while (true) {
            n++;
            if (Integer.bitCount(n) == oneCount) {
                return n;
            }
        }
    }
}

class Solution {
    public int solution(int n) {
        
        int mod = 1234567;
        int prev1 = 0; // F(0)
        int prev2 = 1; // F(1)

        for (int i = 2; i<= n; i++){
            int current = (prev1 + prev2) % mod;
            prev1 = prev2;
            prev2 = current;
        }
        
        return prev2;
    }
}
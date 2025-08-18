class Solution {
    public int solution(int n) {
        
        int answer = Integer.MAX_VALUE;
        for (int x=1000000; x>=2; x--){
            
            if (n % x == 1){
                answer = Math.min(x,answer);
            }
        }
        
        return answer;
    }
}
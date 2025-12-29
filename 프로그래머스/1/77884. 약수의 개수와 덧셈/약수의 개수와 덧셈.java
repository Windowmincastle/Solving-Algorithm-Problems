class Solution {
    public int solution(int left, int right) {
        
        int answer = 0;
        
        for (int i=left; i <= right; i++) {
            
            int count = 0;
            
            for (int j=1; j<=i; j++) {
                
                if ( i % j == 0) {
                    count++;
                }
            }
            
            // 짝수면 값을 더하고
            if (count % 2 == 0 ) {
                answer += i; 
            } else { // 홀수면 값을 뺸다.
                answer -= i;
            }
            
        }
        
        return answer;
    }
}
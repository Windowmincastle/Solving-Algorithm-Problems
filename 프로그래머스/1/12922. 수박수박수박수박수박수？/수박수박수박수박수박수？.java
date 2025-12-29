class Solution {
    public String solution(int n) {

        // 3이면 3개
        // 4면 4개
        // n개면 n개의 글자가 필요
        String answer = "";
        
        for (int i=0; i<n; i++ ){
            
            // 짝수다
            if (i % 2 == 0 ) {
                answer += "수";
            //홀수다
            } else {
                answer += "박";
            }
            
        }
        
        return answer;
    }
}
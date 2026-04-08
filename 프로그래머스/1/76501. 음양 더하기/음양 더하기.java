class Solution {
    public int solution(int[] absolutes, boolean[] signs) {

        int answer = 0;
        
        if (signs[0]) {
            answer = absolutes[0];
        } else {
            answer = -absolutes[0];
        }
        
        for (int i=1; i<absolutes.length; i++) {
            
            if(signs[i]) {
                answer += absolutes[i];
            } else {
                answer += -absolutes[i];
            }
        }
        
        return answer;
    }
}
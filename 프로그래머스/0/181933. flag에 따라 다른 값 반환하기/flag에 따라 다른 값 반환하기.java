class Solution {
    public int solution(int a, int b, boolean flag) {
        int answer = 0;
        
        boolean t = true;
        boolean f = false;
        
        if ( flag == t){
            answer = a + b;
        } else {
            answer = a - b;
        }
    
        return answer;
    }
}
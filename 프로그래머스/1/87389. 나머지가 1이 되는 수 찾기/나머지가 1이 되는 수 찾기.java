class Solution {
    public int solution(int n) {
        int answer = sol(n);
        return answer;
    }
    
    public static int sol(int input){
        
        for(int i=2; i<input; i++){
            if(input % i == 1){
                return i;
            }
        }
        
        return -1;
    }
    
}
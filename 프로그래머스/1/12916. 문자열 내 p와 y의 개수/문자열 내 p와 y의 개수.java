class Solution {
    boolean solution(String s) {
        
        boolean answer = true;
        
        String input = s.toLowerCase();
        
        int pCnt = 0;
        int yCnt = 0;
        
        for(int i=0; i<input.length(); i++){
            
            char temp = input.charAt(i);
            
            if (temp =='p'){
                pCnt++;
            } else if ( temp == 'y'){
                yCnt++;
            }
            
            
            if ( pCnt == yCnt ){
                answer = true;
            } else if ( pCnt != yCnt){
                answer = false;
            } else if ( pCnt == 0 && yCnt == 0){
                answer = true;
            }
            
        }

        return answer;
    }
}
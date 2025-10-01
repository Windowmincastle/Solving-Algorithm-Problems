class Solution {
    
    static boolean confirmStr(String s){
        
        boolean sol = false;
        
        int pCnt = 0;
        int yCnt = 0;
        
        s = s.toLowerCase();
        char[] str = s.toCharArray();
        
        for (int i=0; i<str.length; i++){
            
            if (str[i] == 'p'){
                pCnt++;
            } else if (str[i] == 'y') {
                yCnt++;
            }
            
        }        
        
        if ( pCnt == 0 && yCnt ==0 ){
            sol = true;
            
            return sol;
        }
        
        if ( pCnt == yCnt ){
            sol = true;
        } else {
            sol = false;
        }
        
        return sol;
    }
    
    boolean solution(String s) {
        boolean answer = confirmStr(s);
        return answer;
    }
}
class Solution {
    
    public String solution(String[] seoul) {
        
        int targetX = -1;
        String targetWord = "Kim";
        
        for (int i=0; i<seoul.length; i++) {
            
            if (seoul[i].equals(targetWord)){
                targetX = i;
                break;
            }
        }
        
        String answer = "김서방은 "+String.valueOf(targetX)+"에 있다";
        
        return answer;
    }
}
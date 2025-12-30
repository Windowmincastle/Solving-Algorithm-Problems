class Solution {
    public boolean solution(String s) {
        
        boolean answer = true;
        
        if ( s.length() == 4 || s.length() == 6) {

            for ( char word : s.toCharArray()) {
                
                if (!Character.isDigit(word)) {
                    answer = false;
                }
                
            }
        
        } else {
            answer = false;
        }

        return answer;
    }
}
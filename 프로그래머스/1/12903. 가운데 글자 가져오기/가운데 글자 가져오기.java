class Solution {
    public String solution(String s) {
    
        int a = s.length() / 2;
        if ( s.length() % 2 == 0 ) {
            s = s.substring(a-1, a+1);
        } else {
            s = String.valueOf(s.charAt(a));
        }
        
        return s;
    }
}
class Solution {
    public String solution(String my_string, String alp) {
        String answer;
        String tmp = alp.toUpperCase();
        
        answer = my_string.replace(alp,tmp);
        
        return answer;
    }
}
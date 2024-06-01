class Solution {
    public int solution(String my_string, String is_prefix) {
        int answer = 0;
        
        // is_prefix가 my_string의 접두사인지 확인
        if (my_string.startsWith(is_prefix)) {
            answer = 1;
        } else {
            answer = 0;
        }
        
        return answer;
    }
}

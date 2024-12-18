class Solution {
    public String solution(String s) {
        
        StringBuilder result = new StringBuilder();
        boolean isStartOfWord = true; // 단어 시작 여부를 확인하는 플래그

        for (char c : s.toCharArray()) {
            if (c == ' ') { // 공백인 경우
                result.append(c);
                isStartOfWord = true; // 다음 문자는 단어의 시작
            } else if (isStartOfWord) { // 단어의 시작인 경우
                result.append(Character.toUpperCase(c)); // 대문자로 변환
                isStartOfWord = false; // 단어의 시작 상태 해제
            } else { // 단어 중간인 경우
                result.append(Character.toLowerCase(c)); // 소문자로 변환
            }
        }

        return result.toString();
        
    }
}
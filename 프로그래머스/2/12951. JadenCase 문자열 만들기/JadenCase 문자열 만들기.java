class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        
        // split(" ", -1) -> 연속된 공백도 보존
        String[] words = s.split(" ", -1);

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            
            if (word.length() > 0) {
                char first = word.charAt(0);
                if (Character.isDigit(first)) {
                    // 숫자로 시작하면: 첫 글자는 그대로 두고 나머지는 소문자
                    answer.append(first);
                    if (word.length() > 1) {
                        answer.append(word.substring(1).toLowerCase());
                    }
                } else {
                    // 알파벳으로 시작하면: 첫 글자는 대문자, 나머지는 소문자
                    answer.append(Character.toUpperCase(first));
                    if (word.length() > 1) {
                        answer.append(word.substring(1).toLowerCase());
                    }
                }
            }
            
            if (i < words.length - 1) {
                answer.append(" ");
            }
        }
        
        return answer.toString();
    }
}

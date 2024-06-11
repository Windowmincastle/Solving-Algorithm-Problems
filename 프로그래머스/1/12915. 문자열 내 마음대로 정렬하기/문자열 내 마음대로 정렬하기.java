import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String[] solution(String[] strings, int n) {

        String[] answer = new String[strings.length];
        // Comparator를 사용하여 정렬 기준 정의
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                // 인덱스 n의 문자 비교
                if (s1.charAt(n) == s2.charAt(n)) {
                    // 인덱스 n의 문자가 같으면 사전순으로 비교
                    return s1.compareTo(s2);
                } else {
                    // 인덱스 n의 문자 비교
                    return Character.compare(s1.charAt(n), s2.charAt(n));
                }
            }
        });

        for (int i = 0; i < strings.length; i++) {
            answer[i] = strings[i];
        }
        
        return answer;
    }
}
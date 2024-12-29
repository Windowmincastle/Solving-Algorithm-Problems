import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        
        // 1. 사용된 단어를 저장할 자료 구조 (중복 확인용)
        Set<String> usedWords = new HashSet<>();
        
        // 2. 첫 단어의 끝 글자를 저장할 변수
        char lastChar = words[0].charAt(0); // 첫 단어의 첫 글자를 초기값으로 설정
        
        // 3. 단어를 하나씩 검사
        for (int i = 0; i < words.length; i++) {
            String currentWord = words[i]; // 현재 단어 가져오기
            
            // (1) 중복 단어인지 확인
            if (usedWords.contains(currentWord)) {
                return calculateResult(i, n); // 탈락자 정보 반환
            }
            
            // (2) 끝말잇기 규칙 확인 (앞 단어의 끝 글자와 현재 단어의 첫 글자 비교)
            if (currentWord.charAt(0) != lastChar) {
                return calculateResult(i, n); // 탈락자 정보 반환
            }
            
            // (3) 현재 단어를 사용된 단어 목록에 추가하고, 끝 글자 업데이트
            usedWords.add(currentWord);
            lastChar = currentWord.charAt(currentWord.length() - 1);
        }
        
        // 4. 모든 단어를 통과했다면 탈락자가 없습니다.
        return new int[] {0, 0};
    }

    // 탈락자의 번호와 차례를 계산하는 메서드
    public int[] calculateResult(int index, int n) {
        
        int person = (index % n) + 1; // 탈락한 사람의 번호 (1번부터 시작)
        int turn = (index / n) + 1;  // 그 사람의 몇 번째 차례인지 계산
        
        return new int[] {person, turn};
    }
}

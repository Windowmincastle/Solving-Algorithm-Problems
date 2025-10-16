import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> used = new HashSet<>();
        used.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            String prev = words[i - 1];
            String curr = words[i];

            // 1. 이전 단어의 마지막 글자와 현재 단어의 첫 글자가 다르거나
            // 2. 이미 말한 단어를 또 말한 경우
            if (prev.charAt(prev.length() - 1) != curr.charAt(0) || used.contains(curr)) {
                int person = (i % n) + 1;      // 사람 번호 (1번부터 시작)
                int turn = (i / n) + 1;        // 해당 사람의 차례
                return new int[]{person, turn};
            }

            used.add(curr);
        }

        // 탈락자가 없는 경우
        return new int[]{0, 0};
    }
}

import java.util.*;

class Solution {
    public int[] solution(String msg) {
        // 1. 초기 사전 생성 (A:1 ... Z:26)
        Map<String, Integer> dict = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            dict.put(String.valueOf((char)('A' + i)), i + 1);
        }
        int nextIndex = 27; // 다음에 추가될 색인 번호

        List<Integer> output = new ArrayList<>();
        int pos = 0;
        int n = msg.length();

        // 2. 입력을 순회하면서 가장 긴 w를 찾아 출력하고, w+c를 사전에 등록
        while (pos < n) {
            int j = pos + 1;
            String w = msg.substring(pos, j);

            // 가능한 한 길게 확장
            while (j <= n && dict.containsKey(msg.substring(pos, j))) {
                w = msg.substring(pos, j);
                j++;
                if (j > n) break;
            }

            // w에 해당하는 색인 출력
            output.add(dict.get(w));

            // w 다음에 문자가 있으면 w+c를 사전에 추가
            if (pos + w.length() < n) {
                String wc = msg.substring(pos, pos + w.length() + 1);
                dict.put(wc, nextIndex++);
            }

            pos += w.length();
        }

        // 결과를 int[]로 변환하여 반환
        int[] answer = new int[output.size()];
        for (int i = 0; i < output.size(); i++) answer[i] = output.get(i);
        return answer;
    }
}

import java.util.*;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> dict = new HashMap<>();

        // 1. 사전 초기화 (A~Z → 1~26)
        int nextIndex = 1;
        for (char c = 'A'; c <= 'Z'; c++) {
            dict.put(String.valueOf(c), nextIndex++);
        }

        List<Integer> output = new ArrayList<>();

        int i = 0;
        while (i < msg.length()) {
            String w = "" + msg.charAt(i);
            int j = i + 1;

            // 2. w에 다음 문자를 붙여가며 사전에 있는 가장 긴 문자열 찾기
            while (j <= msg.length()) {
                String candidate = msg.substring(i, j);
                if (dict.containsKey(candidate)) {
                    w = candidate;
                    j++;
                } else {
                    break;
                }
            }

            // 3. 찾은 w의 색인 출력
            output.add(dict.get(w));

            // 4. 가능한 경우에 한해서 w + c 를 사전에 등록
            if (j <= msg.length()) {
                String newEntry = msg.substring(i, j);  // w + c
                dict.put(newEntry, nextIndex++);
            }

            // 5. 포인터 i 를 처리한 길이만큼 전진
            i += w.length();
        }

        // 6. List → int[] 변환
        return output.stream().mapToInt(Integer::intValue).toArray();
    }
}

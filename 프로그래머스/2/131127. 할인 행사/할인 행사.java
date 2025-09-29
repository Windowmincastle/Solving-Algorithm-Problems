import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> wantMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }

        int n = discount.length;
        if (n < 10) return 0;

        Map<String, Integer> window = new HashMap<>();
        // 첫 10일 초기 윈도우 구성
        for (int i = 0; i < 10; i++) {
            window.put(discount[i], window.getOrDefault(discount[i], 0) + 1);
        }

        int answer = 0;
        if (matches(wantMap, window)) answer++;

        // 슬라이딩: start는 윈도우의 시작 인덱스
        for (int start = 1; start <= n - 10; start++) {
            // 나가는 아이템 (start-1)
            String outItem = discount[start - 1];
            int outCount = window.get(outItem);
            if (outCount == 1) window.remove(outItem);
            else window.put(outItem, outCount - 1);

            // 들어오는 아이템 (start+9)
            String inItem = discount[start + 9];
            window.put(inItem, window.getOrDefault(inItem, 0) + 1);

            if (matches(wantMap, window)) answer++;
        }

        return answer;
    }

    private boolean matches(Map<String, Integer> wantMap, Map<String, Integer> window) {
        for (Map.Entry<String, Integer> e : wantMap.entrySet()) {
            if (!window.getOrDefault(e.getKey(), 0).equals(e.getValue())) return false;
        }
        return true;
    }
}

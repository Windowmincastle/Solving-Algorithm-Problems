import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> wantMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }

        int count = 0; // 가능한 날짜 개수
        Map<String, Integer> currentMap = new HashMap<>();

        // 초기 10일 윈도우 설정
        for (int i = 0; i < 10; i++) {
            currentMap.put(discount[i], currentMap.getOrDefault(discount[i], 0) + 1);
        }

        // 윈도우가 want 조건과 일치하는지 확인
        if (compareMaps(wantMap, currentMap)) count++;

        // 슬라이딩 윈도우 시작
        for (int i = 10; i < discount.length; i++) {
            // 윈도우의 앞쪽 제거 (i-10)
            String oldItem = discount[i - 10];
            if (currentMap.get(oldItem) == 1) {
                currentMap.remove(oldItem);
            } else {
                currentMap.put(oldItem, currentMap.get(oldItem) - 1);
            }

            // 윈도우의 뒤쪽 추가 (i)
            String newItem = discount[i];
            currentMap.put(newItem, currentMap.getOrDefault(newItem, 0) + 1);

            // 다시 비교
            if (compareMaps(wantMap, currentMap)) count++;
        }

        return count;
    }

    // 두 Map이 동일한지 비교
    private boolean compareMaps(Map<String, Integer> map1, Map<String, Integer> map2) {
        for (String key : map1.keySet()) {
            if (!map2.containsKey(key) || !map2.get(key).equals(map1.get(key))) {
                return false;
            }
        }
        return true;
    }
}

import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        
        // 1️⃣ 의상 종류별 개수 세기
        for (String[] c : clothes) {
            String type = c[1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }

        // 2️⃣ 조합 계산: 각 종류별 (개수 + 1)을 곱함
        int answer = 1;
        for (int count : map.values()) {
            answer *= (count + 1);
        }

        // 3️⃣ 모두 안 입은 경우 1가지 제외
        return answer - 1;
    }
}

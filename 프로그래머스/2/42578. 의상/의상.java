import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> clothesMap = new HashMap<>();

        // 1. 의상 종류별 개수 저장
        for (String[] item : clothes) {
            String type = item[1]; // 의상의 종류
            clothesMap.put(type, clothesMap.getOrDefault(type, 0) + 1);
        }

        // 2. 조합의 수 계산 (각 종류별 (개수 + 1) 을 곱한 후 전체 -1)
        int answer = 1;
        for (int count : clothesMap.values()) {
            answer *= (count + 1);
        }

        return answer - 1; // 아무것도 입지 않는 경우 제외
    }
}

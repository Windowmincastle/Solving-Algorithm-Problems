import java.util.*;

public class Solution {
    public int solution(String str1, String str2) {
        // 1. 소문자로 바꿔서 대소문자 차이 무시
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        // 2. 두 문자열에서 2글자씩 잘라 유효한 쌍만 카운트한 Map 생성
        Map<String, Integer> map1 = buildMultisetMap(str1);
        Map<String, Integer> map2 = buildMultisetMap(str2);

        // 3. 모든 유니크 키(2글자 조각) 집합 생성
        Set<String> allKeys = new HashSet<>();
        allKeys.addAll(map1.keySet());
        allKeys.addAll(map2.keySet());

        // 4. 교집합 크기, 합집합 크기 계산
        int intersectionSize = 0;
        int unionSize = 0;
        for (String key : allKeys) {
            int count1 = map1.getOrDefault(key, 0);
            int count2 = map2.getOrDefault(key, 0);
            // 교집합: 두 개 중 작은 값
            intersectionSize += Math.min(count1, count2);
            // 합집합: 두 개 중 큰 값
            unionSize += Math.max(count1, count2);
        }

        // 5. 둘 다 공집합인 경우 유사도 1로 정의
        double jaccard;
        if (unionSize == 0) {
            jaccard = 1.0;
        } else {
            jaccard = (double) intersectionSize / unionSize;
        }

        // 6. 65536 곱하고 소수점 버림
        return (int) (jaccard * 65536);
    }

    /**
     * 주어진 문자열을 두 글자씩 잘라,
     * 영문자 쌍만 Map에 카운트하여 반환한다.
     */
    private Map<String, Integer> buildMultisetMap(String s) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length() - 1; i++) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(i + 1);
            // 둘 다 알파벳인지 체크
            if (Character.isLetter(c1) && Character.isLetter(c2)) {
                String pair = s.substring(i, i + 2);
                map.put(pair, map.getOrDefault(pair, 0) + 1);
            }
        }
        return map;
    }
}

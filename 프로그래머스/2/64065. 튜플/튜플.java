import java.util.*;

class Solution {
    public int[] solution(String s) {
        // 1. 바깥의 {{, }} 제거
        s = s.substring(2, s.length() - 2);
        
        // 2. "},{" 기준으로 split
        String[] sets = s.split("\\},\\{");

        // 3. 각 집합 문자열을 리스트로 변환하고, 길이 순으로 정렬
        List<String[]> list = new ArrayList<>();
        for (String set : sets) {
            list.add(set.split(","));
        }
        list.sort(Comparator.comparingInt(a -> a.length)); // 길이순 정렬

        // 4. 순차적으로 튜플 구성
        List<Integer> result = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();

        for (String[] arr : list) {
            for (String numStr : arr) {
                int num = Integer.parseInt(numStr);
                if (!seen.contains(num)) {
                    seen.add(num);
                    result.add(num);
                }
            }
        }

        // 5. 결과 리스트를 배열로 변환
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}

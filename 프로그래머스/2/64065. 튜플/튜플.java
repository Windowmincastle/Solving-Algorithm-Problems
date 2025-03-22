import java.util.*;

class Solution {
    public int[] solution(String s) {
        // 입력 문자열에서 '{'와 '}' 제거 후 분리하여 리스트로 저장
        List<String> list = Arrays.asList(s.replaceAll("[{}]", " ").trim().split(" , "));
        
        // 리스트를 각 요소 개수에 따라 정렬 (튜플의 크기 순서대로 정렬하기 위해)
        list.sort(Comparator.comparingInt(String::length));
        
        // 최종 결과를 저장할 리스트
        List<Integer> result = new ArrayList<>();
        // 이미 추가된 숫자를 확인하기 위한 HashSet (중복 방지)
        Set<Integer> set = new HashSet<>();
        
        for (String str : list) {
            // 쉼표로 숫자를 분리하고, 각 숫자를 순차적으로 확인
            for (String numStr : str.split(",")) {
                int num = Integer.parseInt(numStr.trim()); // 문자열을 정수형으로 변환
                if (set.add(num)) { // set에 추가되면 중복이 아니므로 결과 리스트에 추가
                    result.add(num);
                }
            }
        }
        
        // 리스트를 배열로 변환하여 반환
        return result.stream().mapToInt(i -> i).toArray();
    }
}

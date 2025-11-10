import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        // 1. 두 문자열을 소문자로 변환
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        // 2. 두 글자씩 끊어 다중집합 만들기
        List<String> list1 = makeBigrams(str1);
        List<String> list2 = makeBigrams(str2);

        // 3. 교집합, 합집합 크기 계산
        List<String> intersection = new ArrayList<>();
        List<String> union = new ArrayList<>(list1);

        // list1의 복사본을 이용 (mutable list)
        List<String> temp = new ArrayList<>(list2);
        for (String s : list1) {
            if (temp.contains(s)) {
                intersection.add(s);
                temp.remove(s); // 중복 고려
            }
        }
        union.addAll(temp); // 남은 요소 추가 (합집합)
        
        // 4. 유사도 계산
        double jaccard;
        if (union.size() == 0) {
            jaccard = 1;
        } else {
            jaccard = (double) intersection.size() / union.size();
        }

        // 5. 결과값 계산
        return (int) Math.floor(jaccard * 65536);
    }

    // 문자열을 두 글자씩 끊어 영문자만 포함된 쌍으로 리스트 생성
    private List<String> makeBigrams(String str) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < str.length() - 1; i++) {
            char a = str.charAt(i);
            char b = str.charAt(i + 1);
            if (Character.isLetter(a) && Character.isLetter(b)) {
                list.add("" + a + b);
            }
        }
        return list;
    }
}

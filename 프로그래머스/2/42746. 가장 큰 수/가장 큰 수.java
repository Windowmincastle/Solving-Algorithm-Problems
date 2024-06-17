import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String solution(int[] numbers) {
        // int 배열을 String 배열로 변환
        String[] strNumbers = Arrays.stream(numbers)
                                    .mapToObj(String::valueOf)
                                    .toArray(String[]::new);

        // Comparator를 사용하여 정렬
        Arrays.sort(strNumbers, (a, b) -> (b + a).compareTo(a + b));

        // 모든 숫자가 0인 경우 "0"을 반환
        if (strNumbers[0].equals("0")) {
            return "0";
        }

        // 문자열을 하나로 합침
        StringBuilder answer = new StringBuilder();
        for (String num : strNumbers) {
            answer.append(num);
        }

        return answer.toString();
    }
}
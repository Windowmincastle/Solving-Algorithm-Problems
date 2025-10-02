import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people); // 몸무게 오름차순 정렬
        int left = 0;                // 가장 가벼운 사람 인덱스
        int right = people.length - 1; // 가장 무거운 사람 인덱스
        int answer = 0;

        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                // 둘이 같이 탈 수 있으면
                left++;
                right--;
            } else {
                // 무거운 사람만 태움
                right--;
            }
            answer++;
        }

        return answer;
    }
}

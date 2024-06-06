import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        // 사람들의 몸무게 배열을 정렬합니다.
        Arrays.sort(people);

        // 두 포인터를 설정합니다.
        int left = 0; // 가장 가벼운 사람을 가리키는 포인터
        int right = people.length - 1; // 가장 무거운 사람을 가리키는 포인터
        int boats = 0; // 필요한 구명보트의 개수

        // 포인터가 서로 교차하기 전까지 반복합니다.
        while (left <= right) {
            // 가장 가벼운 사람과 가장 무거운 사람의 무게 합이 제한을 넘지 않는다면
            if (people[left] + people[right] <= limit) {
                // 두 사람을 한 보트에 태웁니다.
                left++;
                right--;
            } else {
                // 무게 합이 제한을 넘는다면 가장 무거운 사람만 태웁니다.
                right--;
            }
            // 보트를 사용했으므로 보트 개수를 증가시킵니다.
            boats++;
        }

        // 필요한 구명보트의 최소 개수를 반환합니다.
        return boats;
    }
}
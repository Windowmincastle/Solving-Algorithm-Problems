import java.util.*;
class Solution {
    public int[] solution(String[] gems) {

        int[] answer = new int[2];
        int n = gems.length;

        // 모든 종류의 보석을 파악하기 위해 HashSet 사용
        HashSet<String> set = new HashSet<>(Arrays.asList(gems));
        int cnt = set.size(); // 보석 종류의 수
        int left = 0,  right = 0, startidx = 0, endidx = 0;
        int minLength = Integer.MAX_VALUE;

        // 현재 범위에서(left~right) 각 보석의 개수를 확인할 때 사용할 map
        HashMap<String, Integer> map = new HashMap<>(); // [다이아:1,루비:2,등등]

        while (true) { //반복문 시작

            if (map.size() == cnt) { // 모든 종류의 보석이 포함된 경우 cnt가 map.size()와 같다는 것은 모든 종류의 보석이 포함이 됐다를 의미

                if ((right - 1) - left < minLength) { // 현재 최단구간보다 현재 구간이 더 최단이라면 갱신한다.
                    startidx = left;
                    endidx = right - 1; // -1을 하는 이유는 ? 정확히 이해가 안된다.
                    // else문에서 right를 증가시키고 다시 반복문에 진입해서 이 조건에 진입한다
                    minLength = (right - 1) - left;
                }

                map.put(gems[left], map.get(gems[left]) - 1); // 모든 종류의 보석이 포함되지 않은 경우이기 때문에 right를 확장하며 보석을 추가한다.

                if (map.get(gems[left]) == 0) { // 해당 보석은 구간에서 빠졌기 때문에 구간에서 제외하기 위해서 remove를 해준다.
                    map.remove(gems[left]);
                }
                left++;

            } else if (right == n) { // right가 배열 끝에 도달한 경우
                break;

            } else { // 모든 보석 종류가 포함되지 않은 경우

                // right 포인터를 증가시키고 map에 현재 right 위치의 보석을 추가한다.
                map.put(gems[right], map.getOrDefault(gems[right], 0) + 1);
                right++;
            }

        }

        answer[0] = startidx + 1; // 0base 계산
        answer[1] = endidx + 1;
        return answer;
    }
}
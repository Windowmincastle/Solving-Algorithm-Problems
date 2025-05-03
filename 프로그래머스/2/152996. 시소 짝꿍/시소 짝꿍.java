import java.util.*;

class Solution {
    public long solution(int[] weights) {
        // 1) 각 몸무게별 등장 횟수를 센다.
        Map<Integer, Long> count = new HashMap<>();
        for (int w : weights) {
            count.put(w, count.getOrDefault(w, 0L) + 1);
        }

        long answer = 0;

        // 2) 같은 무게끼리 거리도 같을 때(2-2, 3-3, 4-4) → 무게가 같아야 토크가 같다
        for (long c : count.values()) {
            answer += c * (c - 1) / 2;
        }

        // 3) 서로 다른 거리 조합에서의 비율 (큰 무게/작은 무게)
        //    (2,3) → 3/2,  (2,4) → 4/2=2,  (3,4) → 4/3
        int[][] ratios = { {3, 2}, {2, 1}, {4, 3} };

        // 4) 무게 w1을 큰 쪽이라 보고, w2 = w1 * (denominator/​numerator) 가 정수인지, 
        //    또 w2 < w1 인 경우에만 count[w1]×count[w2] 만큼 짝을 더한다.
        for (Map.Entry<Integer, Long> e : count.entrySet()) {
            int w1 = e.getKey();
            long c1 = e.getValue();
            for (int[] r : ratios) {
                int num = r[0], den = r[1];
                // w2 = w1 * den / num
                long prod = (long) w1 * den;
                if (prod % num != 0) continue;
                int w2 = (int) (prod / num);
                if (w2 >= w1) continue;            // 중복 방지: 오직 w2 < w1 인 경우만
                Long c2 = count.get(w2);
                if (c2 != null) {
                    answer += c1 * c2;
                }
            }
        }

        return answer;
    }
}

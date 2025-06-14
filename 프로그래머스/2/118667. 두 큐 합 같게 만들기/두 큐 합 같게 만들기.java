import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int n = queue1.length;
        long sum1 = 0, sum2 = 0;
        for (int i = 0; i < n; i++) {
            sum1 += queue1[i];
            sum2 += queue2[i];
        }
        long total = sum1 + sum2;
        if ((total & 1) == 1) {
            return -1;
        }
        long target = total / 2;
        int maxOps = n * 3 * 2; // safe upper bound
        int i = 0, j = n;
        long current = sum1;
        // build combined array of size 2n
        int[] combined = new int[2 * n];
        System.arraycopy(queue1, 0, combined, 0, n);
        System.arraycopy(queue2, 0, combined, n, n);
        int ops = 0;
        while (ops <= maxOps) {
            if (current == target) {
                return ops;
            }
            if (current < target) {
                // move from queue2 to queue1
                current += combined[j % (2 * n)];
                j++;
            } else {
                // move from queue1 to queue2
                current -= combined[i % (2 * n)];
                i++;
            }
            ops++;
        }
        return -1;
    }
}
class Solution {
    public int solution(int[] arr1, int[] arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        
        // 배열 길이가 다르면 더 긴 배열이 크다고 판단
        if (len1 > len2) {
            return 1;
        } else if (len2 > len1) {
            return -1;
        } else {
            // 배열 길이가 같으면 원소의 합을 비교
            int sum1 = 0, sum2 = 0;
            for (int i = 0; i < len1; i++) {
                sum1 += arr1[i];
                sum2 += arr2[i];
            }
            
            if (sum1 > sum2) {
                return 1;
            } else if (sum1 < sum2) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}

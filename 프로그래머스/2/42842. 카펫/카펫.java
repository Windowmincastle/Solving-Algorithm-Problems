class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;

        // 세로 길이 h 후보를 3부터 sqrt(total)까지 검사
        for (int h = 3; h <= Math.sqrt(total); h++) {
            if (total % h != 0) continue;  // w가 정수가 아니면 스킵
            int w = total / h;

            // 중앙 노란색 칸 계산
            if ((w - 2) * (h - 2) == yellow) {
                // 가로가 세로보다 길거나 같도록 반환
                return new int[]{w >= h ? w : h, w >= h ? h : w};
            }
        }

        // 조건 만족하는 값이 없으면 null 반환 (문제 조건상 발생하지 않음)
        return null;
    }
}

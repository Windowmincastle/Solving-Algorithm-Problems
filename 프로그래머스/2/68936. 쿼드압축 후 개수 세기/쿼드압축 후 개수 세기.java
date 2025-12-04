class Solution {
    public int[] solution(int[][] arr) {
        int n = arr.length;
        int[] result = new int[2]; // result[0] = 0의 개수, result[1] = 1의 개수
        compress(arr, 0, 0, n, result);
        return result;
    }

    // (r, c)에서 시작하는 size x size 영역을 처리
    private void compress(int[][] arr, int r, int c, int size, int[] result) {
        if (isUniform(arr, r, c, size)) {
            if (arr[r][c] == 0) result[0]++;
            else result[1]++;
            return;
        }
        int half = size / 2;
        compress(arr, r, c, half, result);                 // 왼쪽 위
        compress(arr, r, c + half, half, result);          // 오른쪽 위
        compress(arr, r + half, c, half, result);          // 왼쪽 아래
        compress(arr, r + half, c + half, half, result);   // 오른쪽 아래
    }

    // 해당 영역이 모두 같은 값이면 true
    private boolean isUniform(int[][] arr, int r, int c, int size) {
        int val = arr[r][c];
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (arr[i][j] != val) return false;
            }
        }
        return true;
    }
}

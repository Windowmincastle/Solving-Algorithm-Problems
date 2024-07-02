import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 입력 처리
        int n = Integer.parseInt(br.readLine());
        int[] ary = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ary[i] = Integer.parseInt(st.nextToken());
        }

        // 배열 정렬
        Arrays.sort(ary);

        int m = Integer.parseInt(br.readLine());
        int[] targetAry = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            targetAry[i] = Integer.parseInt(st.nextToken());
        }

        // 이분 탐색
        for (int target : targetAry) {
            if (binarySearch(ary, target)) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }

        // 결과 출력
        System.out.print(sb);
    }

    private static boolean binarySearch(int[] ary, int target) {
        int start = 0;
        int end = ary.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (ary[mid] == target) {
                return true;
            } else if (ary[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return false;
    }
}

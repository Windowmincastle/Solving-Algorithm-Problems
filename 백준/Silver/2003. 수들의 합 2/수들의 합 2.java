import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 수열의 길이
        int m = Integer.parseInt(st.nextToken()); // 목표 합

        int[] arr = new int[n]; // 수열을 저장할 배열
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken()); // 배열 초기화
        }

        // **두 포인터 알고리즘 시작**
        int left = 0, right = 0;
        int sum = 0; // 부분 합
        int count = 0; // 조건을 만족하는 경우의 수

        while (right < n) {
            // sum을 증가시키면서 right 포인터를 이동
            sum += arr[right];

            // sum이 목표값 M을 초과하면 left 포인터를 이동하며 조정
            while (sum > m && left <= right) {
                sum -= arr[left]; // left 위치 값을 빼고
                left++; // left 포인터 증가
            }

            // 조건을 만족하면 count 증가
            if (sum == m) {
                count++;
            }

            right++; // right 포인터 이동
        }

        // 결과 출력
        System.out.println(count);
        br.close();
    }
}

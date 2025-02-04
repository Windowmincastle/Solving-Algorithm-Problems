import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입출력 도구 설정
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 첫 번째 줄: 순열의 길이 N
        int N = Integer.parseInt(br.readLine());
        
        // 두 번째 줄: 순열 입력
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 이전 순열 계산
        if (previousPermutation(arr)) {
            // 이전 순열이 존재하면 결과 출력
            for (int num : arr) {
                sb.append(num).append(" ");
            }
        } else {
            // 가장 첫 번째 순열이라면 -1 출력
            sb.append("-1");
        }

        System.out.println(sb.toString());
    }

    // 이전 순열을 구하는 메서드
    private static boolean previousPermutation(int[] arr) {
        int n = arr.length;

        // Step 1: 뒤에서부터 탐색하여 처음으로 arr[i-1] > arr[i]인 지점 찾기
        int i = n - 1;
        while (i > 0 && arr[i - 1] <= arr[i]) {
            i--;
        }

        // i가 0이면 이미 가장 작은 순열
        if (i == 0) {
            return false;
        }

        // Step 2: 다시 뒤에서부터 탐색하여 arr[i-1]보다 작은 arr[j]를 찾는다.
        int j = n - 1;
        while (arr[j] >= arr[i - 1]) {
            j--;
        }

        // Step 3: arr[i-1]과 arr[j]를 교환
        swap(arr, i - 1, j);

        // Step 4: i부터 끝까지를 내림차순 정렬 (역순으로 뒤집기)
        reverse(arr, i, n - 1);

        return true; // 이전 순열을 성공적으로 생성
    }

    // 두 요소를 교환하는 메서드
    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    // 배열의 특정 구간을 뒤집는 메서드
    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }
}

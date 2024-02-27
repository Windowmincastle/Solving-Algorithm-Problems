import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();

        int[] lst = new int[n];

        // 초기 바구니 순서 설정
        for (int i = 0; i < n; i++) {
            lst[i] = i + 1;
        }

        // M번 바구니의 순서를 역순으로 만들기
        for (int k = 0; k < m; k++) {
            int i = input.nextInt();
            int j = input.nextInt();

            reverse(lst, i - 1, j - 1);
        }

        // 결과 출력
        for (int num : lst) {
            System.out.print(num + " ");
        }
    }

    // 배열의 일부를 역순으로 만드는 메서드
    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }
}

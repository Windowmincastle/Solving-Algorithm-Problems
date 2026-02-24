import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        if (!prevPermutation(arr)) {
            System.out.println(-1);
        } else {
            StringBuilder sb = new StringBuilder();
            for (int num : arr) {
                sb.append(num).append(" ");
            }
            System.out.println(sb);
        }
    }

    static boolean prevPermutation(int[] arr) {
        int N = arr.length;
        
        // 1️⃣ 뒤에서부터 arr[i-1] > arr[i] 찾기
        int i = N - 1;
        while (i > 0 && arr[i - 1] <= arr[i]) {
            i--;
        }
        
        if (i == 0) return false; // 이미 가장 작은 순열
        
        // 2️⃣ arr[i-1]보다 작은 값 중 가장 큰 값 찾기
        int j = N - 1;
        while (arr[j] >= arr[i - 1]) {
            j--;
        }
        
        // 3️⃣ swap
        swap(arr, i - 1, j);
        
        // 4️⃣ i부터 끝까지 뒤집기 (내림차순)
        int left = i;
        int right = N - 1;
        while (left < right) {
            swap(arr, left, right);
            left++;
            right--;
        }
        
        return true;
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
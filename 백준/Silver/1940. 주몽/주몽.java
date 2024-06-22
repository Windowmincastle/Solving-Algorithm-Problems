import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        // 두 재료의 고유한 번호를 합쳐서 M이 되면 갑옷을 만들 수 있다.
//        갑옷을 몇 개나 만들 수 있나?
//        n = 재료의 개수 1 <= n <= 15,000
//        M = 갑옷을 만드는데 필요한 수 M
//        배열 N개의 재료들이 가진 고유한 번호들이 공백을 사이에 두고 주어짐.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        
        int[] ary = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ary[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        int start = 0;
        int end = ary.length-1;

        Arrays.sort(ary);
        while (start < end) {
            if (ary[start] + ary[end] > m) {
                end--;
            } else if (ary[start] + ary[end] < m) {
                start++;
            } else {
                answer++;
                start++;
            }
        }
        System.out.println(answer);
    }
}

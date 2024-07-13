import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String[] firstLine = br.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        int X = Integer.parseInt(firstLine[1]);
        
        String[] input = br.readLine().split(" ");
        int[] ary = new int[N];
        for (int i = 0; i < N; i++) {
            ary[i] = Integer.parseInt(input[i]);
        }

        // 초기 X일 동안의 합 계산
        int currentSum = 0;
        for (int i = 0; i < X; i++) {
            currentSum += ary[i];
        }

        int maxValue = currentSum;
        int cnt = 1;

        // 슬라이딩 윈도우
        for (int i = X; i < N; i++) {
            currentSum = currentSum + ary[i] - ary[i - X];
            if (currentSum > maxValue) {
                maxValue = currentSum;
                cnt = 1;
            } else if (currentSum == maxValue) {
                cnt++;
            }
        }

        if (maxValue == 0) {
            System.out.println("SAD");
        } else {
            sb.append(maxValue).append("\n");
            sb.append(cnt);
            System.out.println(sb);
        }
    }
}

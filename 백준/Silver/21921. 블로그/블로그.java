import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{


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

        //초기 x일동안의 합을 계산
        int curSum = 0;
        for (int i = 0; i < X; i++) {
            curSum += ary[i];
        }

        int maxValue = curSum;
        int cnt = 1;

        for (int i = X; i < N; i++) {

            curSum = curSum + ary[i] - ary[i - X];

            if (curSum > maxValue) {
                cnt = 1;
                maxValue = curSum;
            } else if (curSum == maxValue) {
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


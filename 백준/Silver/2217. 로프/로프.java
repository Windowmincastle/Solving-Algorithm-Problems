import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Integer[] ary = new Integer[N];
        for (int i =0; i <N; i++) {
            ary[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(ary, Collections.reverseOrder());

        int maxValue = Integer.MIN_VALUE;

        for (int i = 0; i < ary.length; i++) {

            int cnt = i+1;
            int temp = ary[i] * cnt;
            maxValue = Math.max(temp,maxValue);

        }

        System.out.println(maxValue);

    }
}

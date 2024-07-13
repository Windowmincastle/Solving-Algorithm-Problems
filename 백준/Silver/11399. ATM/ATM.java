import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] ary = new int[N];
        
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++){
            ary[i] = Integer.parseInt(input[i]);
        }
        
        Arrays.sort(ary);
        int sum = 0;
        int cumulativeSum = 0;
        for (int i = 0; i < N; i++) {
            cumulativeSum += ary[i];
            sum += cumulativeSum;
        }
        System.out.println(sum);
    }
}

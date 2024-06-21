import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine());
        int cnt = 0;
        int start = 1;
        int end = 1;
        int sum = 1;

        while (start <= end) {
            
            if ( sum == target) cnt++;

            if (sum < target) {
                end++;
                sum += end;
            } else if (sum >= target) {
                sum -= start;
                start++;
            }
        }
        System.out.println(cnt);
    }
}
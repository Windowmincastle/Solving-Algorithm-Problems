import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        int[] ary = {2, 3, 5, 7, 11};

        for (int tc = 1; tc <= T; tc++) {
            int n = Integer.parseInt(br.readLine());
            int[] counts = new int[5]; // 결과 저장

            for (int i = 0; i < ary.length; i++) {
                while (n % ary[i] == 0) {
                    counts[i]++;
                    n /= ary[i];
                }
            }

            sb.append("#").append(tc).append(" ");
            for (int c : counts) {
                sb.append(c).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }
}

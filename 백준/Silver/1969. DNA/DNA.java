import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        String[] dna = new String[N];
        for (int i = 0; i < N; i++) {
            dna[i] = br.readLine();
        }
        
        StringBuilder result = new StringBuilder();
        int totalDistance = 0;
        
        char[] chars = {'A', 'C', 'G', 'T'};
        
        for (int col = 0; col < M; col++) {
            int[] count = new int[4];  // A, C, G, T 카운트
            
            // 현재 열 문자 개수 세기
            for (int row = 0; row < N; row++) {
                char c = dna[row].charAt(col);
                if (c == 'A') count[0]++;
                else if (c == 'C') count[1]++;
                else if (c == 'G') count[2]++;
                else if (c == 'T') count[3]++;
            }
            
            // 가장 많이 나온 문자 찾기
            int maxCount = -1;
            int maxIndex = 0;
            
            for (int i = 0; i < 4; i++) {
                if (count[i] > maxCount) {
                    maxCount = count[i];
                    maxIndex = i;
                }
            }
            
            result.append(chars[maxIndex]);
            totalDistance += (N - maxCount);
        }
        
        System.out.println(result.toString());
        System.out.println(totalDistance);
    }
}

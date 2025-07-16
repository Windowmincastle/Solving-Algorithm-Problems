import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int K = Integer.parseInt(st.nextToken()); // 가지고 있는 랜선 개수
        int N = Integer.parseInt(st.nextToken()); // 필요한 랜선 개수
        
        int[] cables = new int[K];
        int maxLen = 0;
        for (int i = 0; i < K; i++) {
            cables[i] = Integer.parseInt(br.readLine());
            if (cables[i] > maxLen) {
                maxLen = cables[i];
            }
        }
        
        long left = 1;           // 최소 자를 길이
        long right = maxLen;     // 최대 자를 길이
        long result = 0;
        
        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0;
            
            // mid 길이로 잘랐을 때 몇 개의 랜선을 얻을 수 있는지 계산
            for (int len : cables) {
                count += (len / mid);
            }
            
            if (count >= N) {
                // 요구량을 만족하면 길이를 늘려본다
                result = mid;
                left = mid + 1;
            } else {
                // 부족하면 길이를 줄인다
                right = mid - 1;
            }
        }
        
        System.out.println(result);
        br.close();
    }
}

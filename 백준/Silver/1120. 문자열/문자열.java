import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String A = st.nextToken();
        String B = st.nextToken();
        int n = A.length();
        int m = B.length();
        int minDiff = Integer.MAX_VALUE;
        
        // A를 B에 맞춰 앞뒤로 패딩한다 생각하고,
        // B의 길이-n+1 위치만큼 슬라이딩 윈도우 비교
        for (int offset = 0; offset <= m - n; offset++) {
            int diff = 0;
            for (int i = 0; i < n; i++) {
                if (A.charAt(i) != B.charAt(offset + i)) {
                    diff++;
                }
            }
            if (diff < minDiff) {
                minDiff = diff;
            }
            // 최솟값이 0이면 더 이상 줄일 수 없으므로 종료
            if (minDiff == 0) break;
        }
        
        System.out.println(minDiff);
    }
}

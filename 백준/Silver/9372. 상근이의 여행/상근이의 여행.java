import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            
            // 연결을 최소화하려면 트리 구조(간선 N-1)만 타면 충분
            sb.append(N - 1).append('\n');
            
            // 나머지 M개의 비행 정보는 실제로 사용하지 않으므로 읽어서 버림
            for (int i = 0; i < M; i++) {
                br.readLine();
            }
        }
        
        System.out.print(sb.toString());
    }
}

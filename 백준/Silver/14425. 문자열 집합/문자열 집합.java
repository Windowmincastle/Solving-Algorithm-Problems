import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken()); // 집합 S의 문자열 개수
        int m = Integer.parseInt(st.nextToken()); // 검사할 문자열 개수
        
        // 집합 S를 HashSet으로 저장
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }
        
        // 검사 문자열을 체크
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            String check = br.readLine();
            if (set.contains(check)) {
                cnt++;
            }
        }
        
        // 결과 출력
        System.out.println(cnt);
    }
}

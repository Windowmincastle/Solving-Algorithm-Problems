import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력받기
        String[] input = br.readLine().split(" "); // 공백 기준으로 나누기
        int n = Integer.parseInt(input[0]); // 첫 번째 숫자
        int m = Integer.parseInt(input[1]); // 두 번째 숫자
        
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = br.readLine();
        }
        
        int cnt = 0;
        String[] checkStr = new String[m];
        for (int j = 0; j < m; j++) {
            checkStr[j] = br.readLine(); // j 사용
        }
        
        // 비교 로직
        for (int k = 0; k < m; k++) {
            for (int l = 0; l < n; l++) {
                if (checkStr[k].equals(str[l])) {
                    cnt++;
                    break; // 중복 확인 방지
                }
            }
        }
        
        // 결과 출력
        System.out.println(cnt);
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력을 받기 위한 BufferedReader 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력받은 숫자를 문자열로 읽어들임
        String input = br.readLine();
        
        // 입력 문자열을 문자 배열로 변환
        char[] digits = input.toCharArray();
        
        // 문자 배열을 정렬 (오름차순)
        Arrays.sort(digits);
        
        // 내림차순을 위해 배열을 역순으로 추가
        StringBuilder sb = new StringBuilder();
        for (int i = digits.length - 1; i >= 0; i--) {
            sb.append(digits[i]);
        }
        
        // 결과 출력
        System.out.println(sb.toString());
    }
}

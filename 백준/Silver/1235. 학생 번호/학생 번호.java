import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 학생 수 N을 읽음
        int N = Integer.parseInt(br.readLine());
        String[] numbers = new String[N];
        
        // 모든 학생 번호를 읽음
        for (int i = 0; i < N; i++) {
            numbers[i] = br.readLine().trim();
        }
        
        // 번호의 길이는 모두 같으므로 첫 번째 번호의 길이를 이용
        int length = numbers[0].length();
        
        // 뒤에서 k자리만 남겼을 때 고유해지는 최소 k를 찾음
        for (int k = 1; k <= length; k++) {
            Set<String> seen = new HashSet<>(N);
            boolean allUnique = true;
            
            for (String num : numbers) {
                // 뒤에서 k자리 추출
                String suffix = num.substring(length - k);
                if (!seen.add(suffix)) {
                    // 중복이 발생하면 더 이상 검사할 필요 없음
                    allUnique = false;
                    break;
                }
            }
            
            if (allUnique) {
                // 모든 학생이 유일해지는 최소 k를 출력하고 종료
                System.out.println(k);
                break;
            }
        }
    }
}

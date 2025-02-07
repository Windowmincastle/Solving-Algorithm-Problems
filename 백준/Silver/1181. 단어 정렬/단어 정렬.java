import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        // BufferedReader를 사용한 빠른 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        // n개의 단어 입력 받기
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }
        
        // 단어 정렬: 길이 우선, 길이가 같으면 사전 순
        Arrays.sort(words, new Comparator<String>() {
            public int compare(String s1, String s2) {
                if(s1.length() == s2.length()) {
                    return s1.compareTo(s2);
                }
                return s1.length() - s2.length();
            }
        });
        
        // StringBuilder에 정렬된 결과 중 중복 제거하여 저장
        StringBuilder sb = new StringBuilder();
        sb.append(words[0]).append("\n");
        for (int i = 1; i < n; i++) {
            if (!words[i].equals(words[i - 1])) {
                sb.append(words[i]).append("\n");
            }
        }
        
        // 결과 출력
        System.out.print(sb);
    }
}

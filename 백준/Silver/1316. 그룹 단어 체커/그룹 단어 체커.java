import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 단어 개수
        int count = 0; // 그룹 단어 개수

        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            if (isGroupWord(word)) {
                count++;
            }
        }

        System.out.println(count);
    }

    public static boolean isGroupWord(String word) {
        boolean[] visited = new boolean[26]; // 알파벳 등장 여부 저장
        char prev = 0;

        for (int i = 0; i < word.length(); i++) {
            char curr = word.charAt(i);

            if (curr != prev) {
                if (visited[curr - 'a']) {
                    return false; // 이미 등장했던 문자가 다시 나오면 그룹 단어 아님
                }
                visited[curr - 'a'] = true;
                prev = curr;
            }
            // 같을 경우는 연속된 문자이므로 처리 필요 없음
        }

        return true;
    }
}

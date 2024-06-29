import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String word = br.readLine();

        int[] positions = new int[26];
        Arrays.fill(positions, -1);

        // 단어를 순회하면서 알파벳 위치 찾기
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a'; // 알파벳의 인덱스 계산 ('a' = 0, 'b' = 1, ..., 'z' = 25)
            if (positions[index] == -1) { // 처음 등장하는 위치일 때만 업데이트
                positions[index] = i;
            }
        }

        for (int p : positions) {
            System.out.print(p + " ");
        }
    }
}

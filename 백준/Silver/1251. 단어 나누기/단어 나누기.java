import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력을 빠르게 받기 위해 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 단어 입력받기
        String word = br.readLine();

        // 결과를 저장할 변수 (가장 사전순으로 앞서는 단어)
        String bestWord = null;

        int length = word.length();

        // 단어를 세 부분으로 나누는 모든 경우를 시도
        // i: 첫 번째 단어의 마지막 위치 (0부터 length-2까지 가능)
        for (int i = 1; i < length - 1; i++) {
            // j: 두 번째 단어의 마지막 위치 (i+1부터 length-1까지 가능)
            for (int j = i + 1; j < length; j++) {
                // 첫 번째, 두 번째, 세 번째 부분 나누기
                String part1 = word.substring(0, i);
                String part2 = word.substring(i, j);
                String part3 = word.substring(j);

                // 각 부분을 뒤집기
                String reversed1 = new StringBuilder(part1).reverse().toString();
                String reversed2 = new StringBuilder(part2).reverse().toString();
                String reversed3 = new StringBuilder(part3).reverse().toString();

                // 뒤집힌 단어 합치기
                String newWord = reversed1 + reversed2 + reversed3;

                // 사전순으로 가장 앞서는 단어 찾기
                if (bestWord == null || newWord.compareTo(bestWord) < 0) {
                    bestWord = newWord;
                }
            }
        }

        // 결과 출력
        System.out.println(bestWord);
    }
}

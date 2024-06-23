import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력받은 문자열을 앞뒤 공백 제거
        String word = br.readLine().trim();

//      예외 처리
        if (word.length() == 0) {
            System.out.println(0); // 입력이 공백만 있는 경우 단어 수는 0
            return;
        }

        // 공백을 기준으로 문자열을 분할하고 단어 수를 계산
        String[] words = word.split(" "); // 하나 이상의 공백을 기준으로 분할

//        for (String s : words) {
//            System.out.println(s);
//        }

        System.out.println(words.length);
    }
}

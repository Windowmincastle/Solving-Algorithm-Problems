import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int[] words = new int[26];
        //입력 문자열에서 알파벳 빈도수 계산
        for (char c : input.toCharArray()) {
            words[c - 'a']++;
        }
        // 결과 출력
        StringBuilder result = new StringBuilder();
        for (int cnt : words) {
            result.append(cnt).append(" ");
        }
        System.out.println(result.toString().trim());
    }

}

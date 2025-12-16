import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        
        StringBuilder result = new StringBuilder(); // 최종 결과 저장
        StringBuilder word = new StringBuilder();   // 뒤집을 단어 임시 저장
        boolean inTag = false; // 태그 안인지 확인하는 플래그

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '<') {
                // 태그 시작 전까지 쌓인 단어가 있다면 뒤집어서 추가
                result.append(word.reverse().toString());
                word.setLength(0); // 단어 초기화
                inTag = true;
                result.append(ch);
            } else if (ch == '>') {
                inTag = false;
                result.append(ch);
            } else if (inTag) {
                // 태그 내부라면 그대로 추가
                result.append(ch);
            } else {
                // 태그 외부일 때
                if (ch == ' ') {
                    // 공백을 만나면 그동안 쌓인 단어 뒤집어서 추가
                    result.append(word.reverse().toString());
                    result.append(ch);
                    word.setLength(0);
                } else {
                    // 단어 구성 문자라면 임시 저장
                    word.append(ch);
                }
            }
        }
        
        // 마지막에 남은 단어가 있다면 뒤집어서 추가
        result.append(word.reverse().toString());

        System.out.println(result.toString());
    }
}
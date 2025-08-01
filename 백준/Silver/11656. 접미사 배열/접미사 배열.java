import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        List<String> suffixes = new ArrayList<>();
        // 문자열의 모든 접미사를 생성하여 리스트에 추가
        for (int i = 0; i < s.length(); i++) {
            suffixes.add(s.substring(i));
        }

        // 접미사 리스트를 사전순으로 정렬
        Collections.sort(suffixes);

        // 정렬된 접미사들을 한 줄에 하나씩 출력
        for (String suffix : suffixes) {
            System.out.println(suffix);
        }
    }
}
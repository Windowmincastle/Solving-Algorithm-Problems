import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        String input = br.readLine();
        StringBuilder temp = new StringBuilder();
        boolean inTag = false; // 태그 안에 있는지 여부

        for (char c : input.toCharArray()) {
            if (c == '<') {
                // 이전에 쌓인 단어를 뒤집어서 결과에 추가
                result.append(temp.reverse());
                temp.setLength(0); // temp 초기화
                inTag = true; // 태그 시작
                result.append(c); // 태그 여는 문자 추가
            } else if (c == '>') {
                inTag = false; // 태그 종료
                result.append(c); // 태그 닫는 문자 추가
            } else if (inTag) {
                result.append(c); // 태그 내부는 그대로 추가
            } else {
                if (c == ' ') {
                    // 단어가 끝나면 뒤집어서 결과에 추가
                    result.append(temp.reverse());
                    temp.setLength(0); // temp 초기화
                    result.append(c); // 공백 추가
                } else {
                    temp.append(c); // 단어 저장
                }
            }
        }

        // 마지막 단어 처리
        result.append(temp.reverse());

        System.out.println(result.toString());
    }
}

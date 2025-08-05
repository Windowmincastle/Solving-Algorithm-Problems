import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String document = br.readLine();
        String word     = br.readLine();

        char[] docAry  = document.toCharArray();
        char[] wordAry = word.toCharArray();

        int answer = 0;
        int docLen  = docAry.length;
        int wLen    = wordAry.length;

        // i 가 마지막 가능한 시작 인덱스까지 검사하도록 <= 로 설정
        for (int i = 0; i <= docLen - wLen; ) {
            boolean match = true;

            // word 길이만큼 문자 하나하나 비교
            for (int j = 0; j < wLen; j++) {
                if (docAry[i + j] != wordAry[j]) {
                    match = false;  // 하나라도 불일치하면 중단
                    break;
                }
            }

            if (match) {
                answer++;
                // **중복 없이** 세려면, 일치 시 다음 탐색 위치를 단어 길이만큼 건너뛴다
                i += wLen;
            } else {
                // 불일치 시에는 한 칸씩만 이동
                i++;
            }
        }

        // main 메서드 내부에서 출력
        System.out.println(answer);
    }
}

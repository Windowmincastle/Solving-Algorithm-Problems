import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String document = br.readLine();
        String word     = br.readLine();

        int count = 0;
        int docLen = document.length();
        int wLen   = word.length();

        // i 를 직접 조정하는 for 문으로 깔끔하게 처리
        for (int i = 0; i <= docLen - wLen; ) {
            if (document.startsWith(word, i)) {
                count++;
                i += wLen;           // 일치 시엔 단어 길이만큼 건너뛰기
            } else {
                i++;                 // 불일치 시엔 한 칸 이동
            }
        }

        System.out.println(count);
    }
}

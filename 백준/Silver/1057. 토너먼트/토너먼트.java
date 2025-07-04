import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // N은 실제 계산에 필요 없지만 읽어 두었습니다.
        int N = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        int round = 0;
        // 서로 다른 번호를 갖고 있는 한 계속 다음 라운드로 이동시켜 보며
        // 번호가 같아지는(만나는) 순간을 센다.
        while (a != b) {
            // (번호+1)/2 연산이 짝수면 그 번호의 상대편이, 홀수면 본인이 다음 라운드 번호가 된다.
            a = (a + 1) / 2;
            b = (b + 1) / 2;
            round++;
        }
        
        // 만약 절대 만나지 않는다면(이론상 불가능하나 문제 요구사항 반영)
        if (round == 0) {
            System.out.println(-1);
        } else {
            System.out.println(round);
        }
        
        br.close();
    }
}

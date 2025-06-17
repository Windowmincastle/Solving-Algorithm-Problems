import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        if (N == 0) {
            // 책이 하나도 없으면 박스도 필요 없다
            System.out.println(0);
            return;
        }

        st = new StringTokenizer(br.readLine());
        int boxCount = 1;      // 최소 하나의 박스는 필요
        int currentLoad = 0;   // 현재 박스에 담긴 무게 합

        for (int i = 0; i < N; i++) {
            int w = Integer.parseInt(st.nextToken());
            // 다음 책을 넣으면 한도를 초과하는지 확인
            if (currentLoad + w > M) {
                boxCount++;      // 새 박스가 필요
                currentLoad = w; // 새 박스에 이 책부터 담는다
            } else {
                currentLoad += w;
            }
        }

        System.out.println(boxCount);
    }
}

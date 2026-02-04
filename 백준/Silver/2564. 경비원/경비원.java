import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(br.readLine().trim());

        int perimeter = 2 * (W + H);

        int[] shops = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            shops[i] = convertToPerimeterPos(dir, dist, W, H);
        }

        st = new StringTokenizer(br.readLine());
        int guardDir = Integer.parseInt(st.nextToken());
        int guardDist = Integer.parseInt(st.nextToken());
        int guardPos = convertToPerimeterPos(guardDir, guardDist, W, H);

        int total = 0;
        for (int i = 0; i < N; i++) {
            int diff = Math.abs(shops[i] - guardPos);
            total += Math.min(diff, perimeter - diff);
        }

        System.out.println(total);
    }

    // 시계방향으로 top-left (북서) 코너를 시작점(0)으로 하여 둘레상의 위치로 변환
    private static int convertToPerimeterPos(int dir, int dist, int W, int H) {
        // dir: 1=북(위쪽, left->right), 2=남(아래쪽, left->right), 3=서(왼쪽, top->bottom), 4=동(오른쪽, top->bottom)
        // 단, 문제의 방향 정의: 1=북,2=남,3=서,4=동
        if (dir == 1) { // 북: 왼쪽에서 오른쪽
            return dist;
        } else if (dir == 4) { // 동: 위쪽에서 아래쪽
            return W + dist;
        } else if (dir == 2) { // 남: 오른쪽에서 왼쪽 (시계방향으로 보면 top->right->bottom)
            return W + H + (W - dist);
        } else { // dir == 3, 서: 아래쪽에서 위쪽
            return W + H + W + (H - dist);
        }
    }
}

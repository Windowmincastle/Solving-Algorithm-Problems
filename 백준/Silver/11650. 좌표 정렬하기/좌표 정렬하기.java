import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine()); // 점의 개수 입력
        int[][] points = new int[n][2]; // 좌표 저장 배열

        // 좌표 입력 받기
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            points[i][0] = Integer.parseInt(st.nextToken()); // x좌표
            points[i][1] = Integer.parseInt(st.nextToken()); // y좌표
        }

        // 정렬 (x 좌표 기준 오름차순, x좌표 같으면 y좌표 기준 오름차순)
        Arrays.sort(points, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        // 정렬 결과 출력
        for (int i = 0; i < n; i++) {
            sb.append(points[i][0]).append(" ").append(points[i][1]).append("\n");
        }

        System.out.print(sb); // 결과 출력
    }
}

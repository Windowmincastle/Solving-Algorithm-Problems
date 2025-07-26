import java.io.*;
import java.util.*;

public class Main {
    // 점을 저장할 간단한 클래스
    static class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        // 1) 입출력 준비
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        // 2) 점의 개수 N 읽기
        int N = Integer.parseInt(br.readLine());

        // 3) 점들을 저장할 배열 생성
        Point[] points = new Point[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points[i] = new Point(x, y);
        }

        // 4) 정렬: y 오름차순, 같으면 x 오름차순
        Arrays.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                if (p1.y != p2.y) {
                    return p1.y - p2.y;       // y 증가 순
                } else {
                    return p1.x - p2.x;       // y 같을 땐 x 증가 순
                }
            }
        });

        // 5) 결과를 StringBuilder에 쌓기
        for (Point p : points) {
            sb.append(p.x)
              .append(' ')
              .append(p.y)
              .append('\n');
        }

        // 6) 한 번에 출력
        bw.write(sb.toString());
        bw.flush();

        // 7) 리소스 정리
        bw.close();
        br.close();
    }
}

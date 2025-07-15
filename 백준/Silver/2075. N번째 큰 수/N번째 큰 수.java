import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 빠른 입출력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 최소 힙
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            // 줄 단위 입력 받아서 숫자로 분할
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(input[j]);

                // 최소 힙에 삽입
                minHeap.offer(num);

                // 크기가 N을 넘으면 가장 작은 값 제거
                if (minHeap.size() > N) {
                    minHeap.poll();
                }
            }
        }

        // 힙의 루트가 N번째 큰 수
        System.out.println(minHeap.peek());
    }
}

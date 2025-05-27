import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 총 책 수
        int M = Integer.parseInt(st.nextToken()); // 더미 수

        Deque<Integer>[] stacks = new ArrayDeque[M]; // 더미들

        for (int i = 0; i < M; i++) {
            int k = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            stacks[i] = new ArrayDeque<>();
            for (int j = 0; j < k; j++) {
                stacks[i].addLast(Integer.parseInt(st.nextToken()));
            }
        }

        // 우선순위 큐: top값 기준 오름차순
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < M; i++) {
            if (!stacks[i].isEmpty()) {
                pq.offer(new int[]{stacks[i].peekLast(), i}); // [top 값, 더미 인덱스]
            }
        }

        int current = 1;
        while (current <= N) {
            if (pq.isEmpty()) {
                System.out.println("No");
                return;
            }

            int[] top = pq.peek();
            if (top[0] != current) {
                System.out.println("No");
                return;
            }

            pq.poll();
            stacks[top[1]].pollLast(); // 해당 더미에서 책 꺼냄

            // 더미가 비어 있지 않으면 새로운 top을 pq에 넣음
            if (!stacks[top[1]].isEmpty()) {
                pq.offer(new int[]{stacks[top[1]].peekLast(), top[1]});
            }

            current++;
        }

        System.out.println("Yes");
    }
}

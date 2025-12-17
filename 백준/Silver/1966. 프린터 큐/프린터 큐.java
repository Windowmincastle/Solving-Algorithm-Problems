import java.io.*;
import java.util.*;

public class Main {

    static class Document {
        int priority;
        int index;

        Document(int priority, int index) {
            this.priority = priority;
            this.index = index;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Queue<Document> queue = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int priority = Integer.parseInt(st.nextToken());
                queue.offer(new Document(priority, i));
            }

            int printOrder = 0;

            while (true) {
                Document current = queue.poll();
                boolean hasHigherPriority = false;

                for (Document doc : queue) {
                    if (doc.priority > current.priority) {
                        hasHigherPriority = true;
                        break;
                    }
                }

                if (hasHigherPriority) {
                    queue.offer(current);
                } else {
                    printOrder++;
                    if (current.index == M) {
                        sb.append(printOrder).append('\n');
                        break;
                    }
                }
            }
        }

        System.out.print(sb);
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            String command = br.readLine();

            if (command.startsWith("push")) {
                int x = Integer.parseInt(command.split(" ")[1]);
                stack.push(x);

            } else if (command.equals("pop")) {
                if (stack.isEmpty()) {
                    sb.append(-1).append('\n');
                } else {
                    sb.append(stack.pop()).append('\n');
                }

            } else if (command.equals("size")) {
                sb.append(stack.size()).append('\n');

            } else if (command.equals("empty")) {
                sb.append(stack.isEmpty() ? 1 : 0).append('\n');

            } else if (command.equals("top")) {
                if (stack.isEmpty()) {
                    sb.append(-1).append('\n');
                } else {
                    sb.append(stack.peek()).append('\n');
                }
            }
        }

        System.out.print(sb.toString());
    }
}

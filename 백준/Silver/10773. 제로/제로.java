import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < K; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                if (!deque.isEmpty()) deque.removeLast();
            } else{
                deque.add(input);
            }
        }

        int answer = 0;
        for (int i : deque) {
            answer += i;
        }
        System.out.println(answer);

    }
}

import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();

        for (int i =1; i<=n; i++){
            q.add(i);
        }

        while (q.size() > 1) {

            // 맨위 카드를 버림.
            sb.append(q.poll()).append(" ");
            //맨 위 카드를 맨 뒤로 이동
            q.add(q.poll());

        }

        sb.append(q.poll()); // 마지막 남은 카드 추가
        
        System.out.println(sb);

    }
}

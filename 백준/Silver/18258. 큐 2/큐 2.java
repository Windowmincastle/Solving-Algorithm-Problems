import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> q = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            String[] com = br.readLine().split(" ");
            
            if (com[0].equals("push")) {
                q.addLast(Integer.parseInt(com[1]));
            } else if (com[0].equals("pop")) {
                sb.append(q.isEmpty() ? "-1" : q.removeFirst()).append("\n");
            } else if (com[0].equals("size")) {
                sb.append(q.size()).append("\n");
            } else if (com[0].equals("empty")) {
                sb.append(q.isEmpty() ? "1" : "0").append("\n");
            } else if (com[0].equals("front")) {
                sb.append(q.isEmpty() ? "-1" : q.getFirst()).append("\n");
            } else if (com[0].equals("back")) {
                sb.append(q.isEmpty() ? "-1" : q.getLast()).append("\n");
            }
        }
        System.out.print(sb);
    }
}

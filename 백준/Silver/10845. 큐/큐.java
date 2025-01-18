import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            
            String[] commands = br.readLine().split(" ");
            
            if (commands[0].equals("push")) {
                // String을 Integer로 변환 후 큐에 추가
                q.add(Integer.parseInt(commands[1]));
                
            } else if (commands[0].equals("pop")) {
                if (!q.isEmpty()) {
                    System.out.println(q.poll());
                } else {
                    System.out.println("-1");
                }
                
            } else if (commands[0].equals("size")) {
                System.out.println(q.size());
                
            } else if (commands[0].equals("empty")) {
                System.out.println(q.isEmpty() ? 1 : 0);
                
            } else if (commands[0].equals("front")) {
                System.out.println(q.isEmpty() ? -1 : q.peek());
                
            } else if (commands[0].equals("back")) {
                // 큐가 비어 있지 않으면 뒤에 있는 요소 출력
                System.out.println(q.isEmpty() ? -1 : ((LinkedList<Integer>) q).getLast());
            }
        }
    }
}

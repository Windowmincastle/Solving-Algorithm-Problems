import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> dq = new ArrayDeque<>();
        
        int n = Integer.parseInt(br.readLine());
        
        for (int i=0; i<n; i++) {
            
            
            String[] actions = br.readLine().split(" ");
            String com = actions[0];
            
            if (com.equals("push")) {
                String value = actions[1];
                dq.offerFirst(Integer.parseInt(value));
            } else if (com.equals("pop")) {
                if (!dq.isEmpty()) {
                    System.out.println(dq.pollFirst());
                } else {
                    System.out.println("-1");
                }
            } else if (com.equals("size")) {
                System.out.println(dq.size());
            } else if (com.equals("empty")) {
                
                if(dq.isEmpty()) {
                    System.out.println("1");
                } else {
                    System.out.println("0");
                }
            } else if (com.equals("top")) {
                if(!dq.isEmpty()) {
                    System.out.println(dq.peekFirst());
                } else {
                    System.out.println("-1");
                }
            }
        }
    }
}
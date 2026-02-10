import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> dq = new ArrayDeque<>();
        String empty = "-1";
        int n = Integer.parseInt(br.readLine());
        
        for (int i=0; i<n; i++) {
            
            String[] orders = br.readLine().split(" ");
            
            switch(orders[0]) {
                case "push_front": {
                    int value = Integer.parseInt(orders[1]);
                    dq.offerFirst(value);
                }
                    break;
                case "push_back": {
                    int value = Integer.parseInt(orders[1]);
                    dq.offerLast(value);
                }
                    break;
                case "pop_front":
                    if(!dq.isEmpty()) {
                        System.out.println(dq.pollFirst());
                    } else {
                        System.out.println(empty);
                    }
                    break;
                case "pop_back":
                    if(!dq.isEmpty()) {
                        System.out.println(dq.pollLast());
                    } else {
                        System.out.println(empty);
                    }
                    break;
                case "size":
                    System.out.println(dq.size());
                    break;
                case "empty":
                    if (!dq.isEmpty()) {
                        System.out.println("0");
                    } else {
                        System.out.println("1");
                    }
                    break;
                case "front":
                    if(!dq.isEmpty()) {
                        System.out.println(dq.peekFirst());
                    } else {
                        System.out.println(empty);
                    }
                    break;
                case "back":
                    if(!dq.isEmpty()) {
                        System.out.println(dq.peekLast());
                    } else {
                        System.out.println(empty);
                    }
                    break;
                    
            }
            
        }
        
        
        
    }
    
}
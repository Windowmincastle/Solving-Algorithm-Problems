import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        
        for (int i=0; i<n; i++){
            
            String[] input = br.readLine().split(" ");
            if (input[0].equals("push_front")){
                
                deque.addFirst(Integer.parseInt(input[1]));
                
            } else if (input[0].equals("push_back")){
                
                deque.addLast(Integer.parseInt(input[1]));
            
            } else if (input[0].equals("pop_front")){
                
                if (deque.size() == 0) {
                    System.out.println(-1);
                } else {
                    System.out.println(deque.removeFirst());
                }
            
            } else if (input[0].equals("size")) {
                System.out.println(deque.size());
            } else if (input[0].equals("empty")){
                
                if (deque.size() == 0 ){
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
                
            } else if (input[0].equals("front")){
                if ( deque.size()==0) {
                    System.out.println(-1);
                } else {
                    System.out.println(deque.peekFirst());
                }
            } else if (input[0].equals("back")){
                                if ( deque.size()==0) {
                    System.out.println(-1);
                } else {
                    System.out.println(deque.peekLast());
                }
            } else if (input[0].equals("pop_back")){
                
                if (deque.size() == 0){
                    System.out.println(-1);
                } else {
                    System.out.println(deque.removeLast());
                }
            }
        }
    }
}
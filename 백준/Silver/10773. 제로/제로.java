import java.io.*;
import java.util.*;

public class Main {

    static int solution(BufferedReader br, int k) throws Exception {

        Deque<Integer> list = new ArrayDeque<>();
        
        for(int i=0; i<k; i++){
            
            int temp = Integer.parseInt(br.readLine());
            
            if ( temp != 0){
                list.add(temp);
            } else {
                list.removeLast();
            }
        }
        int total = 0;
        for ( int x : list){
            total += x;
        }
        return total;
    }
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int answer = solution(br,k);
        System.out.println(answer);
    }
}
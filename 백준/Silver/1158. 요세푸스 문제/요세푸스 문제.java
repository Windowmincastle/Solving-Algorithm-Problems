
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        Queue<Integer> q = new LinkedList<>();
        
        for (int i=1; i <= n; i++){
            q.offer(i);
        }
        
        
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        
        while (!q.isEmpty()) {
            
            for (int i = 0; i< k-1; i++){
                q.offer(q.poll());
            }

            sb.append(q.poll());
            if (!q.isEmpty()) {
                
                sb.append(", ");

            }

            

        }

        sb.append(">");
        System.out.println(sb);

    }
}

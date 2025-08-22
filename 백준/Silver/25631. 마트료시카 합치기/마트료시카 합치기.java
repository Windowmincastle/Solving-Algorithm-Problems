import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        
        Map<Integer, Integer> count = new HashMap<>();
        int maxFreq = 0;
        
        for (String s : arr) {
            int x = Integer.parseInt(s);
            count.put(x, count.getOrDefault(x, 0) + 1);
            maxFreq = Math.max(maxFreq, count.get(x));
        }
        
        System.out.println(maxFreq);
    }
}

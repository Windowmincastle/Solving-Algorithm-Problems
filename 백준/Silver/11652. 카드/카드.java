import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        long[] cards = new long[N];
        
        for (int i = 0; i < N; i++) {
            cards[i] = Long.parseLong(br.readLine());
        }
        
        Arrays.sort(cards);
        
        long answer = cards[0];
        long current = cards[0];
        int currentCount = 1;
        int maxCount = 1;
        
        for (int i = 1; i < N; i++) {
            if (cards[i] == current) {
                currentCount++;
            } else {
                current = cards[i];
                currentCount = 1;
            }
            
            if (currentCount > maxCount) {
                maxCount = currentCount;
                answer = current;
            }
        }
        
        System.out.println(answer);
    }
}

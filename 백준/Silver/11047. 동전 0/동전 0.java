import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        int coinCnt = 0;
        
        List<Integer> coinLst = new ArrayList<>();
        
        for (int i=0; i<n; i++) {
            coinLst.add(Integer.parseInt(br.readLine()));
        }
        
        // Comparator 람다식으로 내람차순 정렬
        coinLst.sort((o1,o2)->o2-o1);
        
        while(k >= 0) {
            
            if (k == 0) break;
            
            for (int coin : coinLst) {
                
                if ( coin <= k ) {
                    coinCnt += k / coin;
                    k = k % coin;
                    break;
                }
            }
        }
        
        System.out.println(coinCnt);
    }
    
}
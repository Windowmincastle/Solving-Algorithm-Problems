import java.io.*;
import java.util.*;

public class Main {
    
    public static int[] baguni;
    
    public static void swap (int ball1, int ball2) {
        
        int temp = baguni[ball1];      // 1번 공을 temp에 넣고
        baguni[ball1] = baguni[ball2]; // 1번에 2번을 넣고
        baguni[ball2] = temp;  // 2번에 1번을 넣음
    
    }
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        
        int n = Integer.parseInt(inputs[0]); // 바구니 개수
        int m = Integer.parseInt(inputs[1]); // m번 교환
        
        baguni = new int[n+1]; // 1-based indexing을 위해서 +1
        
        // 바구니 데이터 초기화
        for (int i=1; i<n+1; i++) {
            baguni[i] = i;
        }
        
        for (int i=0; i<m; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int ball1 = Integer.parseInt(st.nextToken());
            int ball2 = Integer.parseInt(st.nextToken());
            
            swap(ball1,ball2);
            
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i=1; i<n+1; i++) {
            sb.append(baguni[i]).append(" ");
        }
        
        System.out.println(sb.toString());
        
    }
}
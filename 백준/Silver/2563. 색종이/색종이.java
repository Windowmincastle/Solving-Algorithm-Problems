import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int size = 100;
        boolean[][] paper = new boolean[size][size];
        
        for(int k=0; k<n; k++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            for(int i = x; i< x + 10; i++){
                for (int j = y; j<y + 10; j++){
                    paper[i][j] = true;
                }
            }
        }
        
        int area = 0;
        
        for (int i=0; i< size; i++){
            for (int j=0; j<size; j++){
                if (paper[i][j]) area++;
            }
        }
        System.out.println(area);
    }
    
}
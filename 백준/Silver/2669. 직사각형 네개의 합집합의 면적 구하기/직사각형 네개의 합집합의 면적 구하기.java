import java.io.*;
import java.util.*;

public class Main{
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int size = 101;
        
        boolean[][] grid = new boolean[size][size];
        
        //4개의 직사각형에 대해서 처리하기.
        for (int i=0; i<4; i++){
            
            st = new StringTokenizer(br.readLine());
            
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            
            
            for (int x= x1; x < x2; x++){
                for (int y=y1; y<y2; y++){
                    grid[x][y] = true;
                }
            }
        }
        
        int cnt = 0;
        
        for(int x=0; x<=100; x++){
            for(int y=0; y<=100; y++){
                if (grid[x][y]){
                    cnt++;
                }
            }
        }
        
        System.out.println(cnt);
    }
    
}
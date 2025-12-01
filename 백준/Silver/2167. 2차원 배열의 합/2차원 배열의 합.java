import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        
        int[][] ary = new int[n][m];
        
        for(int i=0; i<n; i++){
            String[] temp = br.readLine().split(" ");
            for (int j=0; j<m; j++){
                ary[i][j] = Integer.parseInt(temp[j]);
            }
        }

        int k = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(k-- > 0){
            String[] ip = br.readLine().split(" ");
            
            int startX = Integer.parseInt(ip[0]) - 1;
            int startY = Integer.parseInt(ip[1]) - 1;
            int endX   = Integer.parseInt(ip[2]) - 1;
            int endY   = Integer.parseInt(ip[3]) - 1;

            int sum = 0;

            for(int i=startX; i<=endX; i++){
                for(int j=startY; j<=endY; j++){
                    sum += ary[i][j];
                }
            }

            sb.append(sum).append("\n");
        }

        System.out.print(sb.toString());
    }
}

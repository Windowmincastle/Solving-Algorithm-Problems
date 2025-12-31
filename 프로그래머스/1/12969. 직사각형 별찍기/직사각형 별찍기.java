import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        int row = Integer.parseInt(input[0]);
        int col = Integer.parseInt(input[1]);
        StringBuilder sb = new StringBuilder();
        
        for (int i=0; i<col; i++) {
            for (int j=0; j<row; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        

        System.out.println(sb.toString());
    }
}
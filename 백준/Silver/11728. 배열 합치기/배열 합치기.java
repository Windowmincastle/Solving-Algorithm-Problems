import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int aLen = Integer.parseInt(input[0]);
        int bLen = Integer.parseInt(input[1]);
        
        int[] A = new int[aLen];
        String[] temp = br.readLine().split(" ");
        
        for (int i=0; i<aLen; i++) {
            A[i] = Integer.parseInt(temp[i]);
        }
        
        int[] B = new int[bLen];
        String[] temp2 = br.readLine().split(" ");
        for (int j=0; j<bLen; j++) {
            B[j] = Integer.parseInt(temp2[j]);
        }
        
        List<Integer> list = new ArrayList<>();
        
        int pointer1 = 0, pointer2 = 0;
        while (pointer1 < aLen && pointer2 < bLen ) {
            if (A[pointer1] < B[pointer2] ) {
                list.add(A[pointer1]);
                pointer1++;
            } else {
                list.add(B[pointer2]);
                pointer2++;
            }
        }
        
        while(pointer1<aLen) {
            list.add(A[pointer1]);
            pointer1++;
        }
        
        while(pointer2<bLen){
          list.add(B[pointer2]);
          pointer2++;
        } 
        
        StringBuilder sb = new StringBuilder();
        
        for (int num : list) {
            sb.append(num).append(" ");
        }
        
        System.out.println(sb.toString());
    }
}
import java.io.*;
import java.util.*;

class Main {
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] inputs = br.readLine().split(" ");
        
        int a = Integer.parseInt(inputs[0]);
        int b = Integer.parseInt(inputs[1]);
        
        System.out.println(a+b);
        
    }
    
}
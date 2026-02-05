import java.io.*;
import java.util.*;

public class Main {
    
    public static String reverse(String value) {
        String revStr = new StringBuilder(value).reverse().toString();
        return revStr;
    }
    
    public static void answer(String v1, String v2) {
        
        int intV1 = Integer.parseInt(v1);
        int intV2 = Integer.parseInt(v2);
        
        if (intV1 > intV2) {
            System.out.println(intV1);
        } else {
            System.out.println(intV2);
        }
    } 
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        String value1 = reverse(inputs[0]);
        String value2 = reverse(inputs[1]);
        answer(value1,value2);
    }
}
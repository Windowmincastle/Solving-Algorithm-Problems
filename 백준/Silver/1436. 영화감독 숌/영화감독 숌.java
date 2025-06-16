import java.io.*;
import java.util.*;

public class Main{
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        int number = 665;
        String TEMP = "666";
        
        while(true){
            
            number++;
            
            String tempStr = String.valueOf(number);
            
            if(tempStr.contains(TEMP)){
                count++;
            }
            
            if ( count == n ) {
                break;
            }
            
        }
        
        System.out.println(number);
        
    }   

}
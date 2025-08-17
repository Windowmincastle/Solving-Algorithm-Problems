import java.util.*;
import java.io.*;

public class Main {
    
    static int searchWordContain(BufferedReader br,String target,int loopCount) throws Exception {

        int count = 0;
        int flag = 0;
        
        while (flag < loopCount ){
            
            String word = br.readLine();
            word += word;
            if (word.contains(target)){
                count++;
                flag++;
            } else {
                flag++;
            }
            
        }
        
        return count;
    }
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String target = br.readLine();
        int loopCount = Integer.parseInt(br.readLine());
        System.out.println(searchWordContain(br,target,loopCount));
        
        
    }
}
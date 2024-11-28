import java.io.*;

public class Main{

    public static void main(String[] args) throws Exception {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        
        String[] Alphabet = {"c=","c-","dz=","d-","lj","nj","s=","z="};
        
        for ( String a : Alphabet){
        
            input = input.replace(a,",");
            
        }
        
        System.out.println(input.length());
        
    }

}
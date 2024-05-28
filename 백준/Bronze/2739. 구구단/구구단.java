import java.util.*;

public class Main{
    
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        
        int input = scan.nextInt();
        
        for(int i=1; i<10; i++)
        {
            System.out.println(input+" * "+ i +" = "+  input*i);
        }
    }
    
}
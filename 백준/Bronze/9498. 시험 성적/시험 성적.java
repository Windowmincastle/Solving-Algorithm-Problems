import java.util.*;

public class Main{
    
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        
        int score = scan.nextInt();
        
        if( 100 >= score && 90 <= score)
        {
            System.out.println("A");
        }
        else if( 89 >= score &&  80 <= score)
        {
            System.out.println("B");
        }
        else if( 79 >= score  && 70 <= score)
        {
            System.out.println("C");
        }
        else if( 69 >= score && 60 <= score)
        {
            System.out.println("D");
        }
        else
        {
            System.out.println("F");   
        }
    }
}
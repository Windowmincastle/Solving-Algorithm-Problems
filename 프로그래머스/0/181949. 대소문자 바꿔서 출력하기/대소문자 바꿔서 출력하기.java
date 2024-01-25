import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        
        String answer = "";
        
        for (int i=0; i<str.length(); i++){
            
            char check = str.charAt(i);
            
            if (Character.isUpperCase(check)){
                answer += Character.toLowerCase(check);
            } else if (Character.isLowerCase(check)){
                answer += Character.toUpperCase(check);
            }
            
        }
        
        System.out.println(answer);
        
    }
}
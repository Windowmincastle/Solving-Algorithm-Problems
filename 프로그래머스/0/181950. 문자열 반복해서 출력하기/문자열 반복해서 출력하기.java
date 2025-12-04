import java.util.Scanner;

public class Solution {
    
    static void printStr(String strInput, int n){
        
        String answer = "";
        
        for (int i=0; i<n; i++){
            answer += strInput;
        }
        
        System.out.println(answer);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = sc.nextInt();
        
        printStr(str,n);
        
    }
}
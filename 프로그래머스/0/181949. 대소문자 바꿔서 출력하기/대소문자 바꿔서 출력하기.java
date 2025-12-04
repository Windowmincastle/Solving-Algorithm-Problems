import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    
    static void printConvertCase(String inputStr) {
        
        int size = inputStr.length();
        Character[] ctr = new Character[size];
        
        for (int i=0; i<size; i++){
            ctr[i] = inputStr.charAt(i);
        }
        
        for (int j=0; j<ctr.length; j++){
            
            if (Character.isUpperCase(ctr[j])){
                // 대문자면? 소문자로
                ctr[j] = Character.toLowerCase(ctr[j]);
            } else {
                // 소문자인거니까,
                ctr[j] = Character.toUpperCase(ctr[j]);
            }
            
        }
        
        String answer = Arrays.stream(ctr)
                        .map(String::valueOf)
                        .collect(Collectors.joining());
        
        System.out.println(answer);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        printConvertCase(a);
    }
}
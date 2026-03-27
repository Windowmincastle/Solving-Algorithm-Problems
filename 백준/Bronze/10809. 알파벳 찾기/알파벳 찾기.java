import java.io.*;
import java.util.*;

class Main {
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String input = br.readLine();
        char[] toCharAry = input.toCharArray();
        char[] alpas = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r',
                        's','t','u','v','w','x','y','z'};
        Map<Character,Integer> map = new TreeMap<>();
        
        for (char alpa : alpas) {
            map.put(alpa,-1);
        }
        
        for (int i=0; i<input.length(); i++) {
            
            String word = String.valueOf(input.charAt(i)); // 단어를 가져와서 char -> String
            // back를 읽어서 indexOf로 위치를 찾아야함.
            int position = input.indexOf(word);
            map.put(
                word.charAt(0),
                position
            );
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (Integer value : map.values()) {
            sb.append(value).append(" ");
        }
        
        System.out.println(sb);
        
    }
    
}
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<Character, Integer> words = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            char word = (char) ('a' + i);
            words.put(word, 0);
        }

        String input = br.readLine().toLowerCase();
        int len = input.length();

        for (int i = 0; i < len; i++) {
            char currentWord = input.charAt(i);
            words.put(currentWord, words.get(currentWord) + 1);
        }

        int maxCount = 0;
        int eqVal = 0;
        for (int value : words.values()) {
            if (value > maxCount) {
                maxCount = value;
            }
        }
        
        
        char answer = '?';
        for (int k=0; k<words.size(); k++){
            
            char c =(char)('a'+k);
            if(words.get(c) == maxCount){
                answer = (char)(c - 32);
                eqVal++;
            }
            
        }
        
        if( eqVal > 1) {
            System.out.println("?");
        } else {
            System.out.println(answer);
        }
    }
}

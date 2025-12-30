import java.util.*;
import java.io.*;

class Solution {

    public String solution(String s) {
        
        List<Character> words = new ArrayList<>();
        
        for (char word : s.toCharArray()) {
            words.add(word);
        }
        
        Collections.sort(words, Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for (char word : words ) {
            sb.append(word);
        }
        
        return sb.toString();
    }
}
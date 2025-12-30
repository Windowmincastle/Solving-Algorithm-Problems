import java.util.*;

class Solution {
    
    List<String> list = new ArrayList<>();
    String[] words = {"A","E","I","O","U"};
    
    public int solution(String word) {
        
        createWord("",0);
        return list.indexOf(word);
    }
    
    public void createWord(String current, int depth) {
        
        list.add(current);
        
        if ( depth == 5 ) return;
        
        for (int i=0; i<5; i++) {
            
            createWord(current+words[i], depth+1);
        }
        
    }
    
}
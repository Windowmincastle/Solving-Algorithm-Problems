import java.util.*;

class Solution {
    public long solution(long n) {
        
        char[] words = String.valueOf(n).toCharArray();
        Arrays.sort(words);
        
        StringBuilder sb = new StringBuilder(new String(words));
        sb.reverse();
        
        return Long.parseLong(sb.toString());
    }
}
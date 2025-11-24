import java.util.*;

public class Solution {
    public int solution(int n) {

        int answer = 0;
        
        String s = String.valueOf(n);
        char[] ary = s.toCharArray();
        
        for (char c : ary){
            answer += c - '0';
        }

        return answer;
    }
}
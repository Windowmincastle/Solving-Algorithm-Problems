import java.io.*;
import java.util.*;

class Solution {
    public long[] solution(long n) {
        
        int len = String.valueOf(n).length();
        StringBuilder sb = new StringBuilder(String.valueOf(n));
        sb.reverse();
        
        String sbToString = sb.toString();
        
        long temp = Long.parseLong(sbToString);
        
        long[] answer = new long[len];
        
        // 5 4 3 2 1
        for (int i=answer.length-1; i>=0; i--) {
            answer[i] = temp % 10;
            temp = temp / 10;
        }
        
        return answer;
    }
}
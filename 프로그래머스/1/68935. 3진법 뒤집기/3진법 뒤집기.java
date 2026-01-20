import java.io.*;
import java.util.*;

class Solution {
    
    public String reverseInteger(int num) {
        
        // num을 3진법으로 변환
        String convertStr = Integer.toString(num,3);
        // 3진법으로 변환한 String을 reverse
        StringBuilder sb = new StringBuilder(convertStr).reverse();
        
        return sb.toString();
    }
    
    public int solution(int n) {
        
        int answer = 0;
        String reverseStr = reverseInteger(n);
        answer = Integer.parseInt(reverseStr,3);
        
        return answer;
    }
}
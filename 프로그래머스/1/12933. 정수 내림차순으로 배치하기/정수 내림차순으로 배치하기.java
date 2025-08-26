import java.io.*;
import java.util.*;
class Solution {
    public long solution(long n) {

        String input = String.valueOf(n);
        char[] ary = input.toCharArray();
        
        List<Integer> list = new ArrayList<>();
        
        for (int i=0; i<ary.length; i++){
            
            list.add(ary[i] -'0');
            
        }
        
        Collections.sort(list,Collections.reverseOrder());
        String temp = "";
        
        for (int i=0; i<list.size(); i++){
            temp += String.valueOf(list.get(i));
        }
        
        
        long answer = Long.parseLong(temp);
        return answer;
    }
}
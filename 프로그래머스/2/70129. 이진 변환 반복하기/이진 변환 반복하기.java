import java.io.*;
import java.util.*;

class Solution {
    
    public static String getBinary(int input){
        
        String res = Integer.toBinaryString(input);
        return res;
    }
    
    public static String getRemoveZeroString(String str){
        
        String res = str.replace("0","");
        
        return res;
    }
    
    public int[] solution(String s) {
        
        int count = 0;
        int removeCount = 0;
        int[] answer = new int[2];
        
        while (!s.equals("1")){
            
            // 문자열 s가 1이 아니라면 진입했겟지.
            count++; // 회차 카운트
            removeCount += s.length() - s.replace("0","").length(); // 제거할 0 의 개수 저장.
            
            s = getRemoveZeroString(s); // 0을 제거하고
            int temp = s.length(); // 제거후 문자열의 길이를 임시 저장후
            s = getBinary(temp); // 그 길이를 이진수로 변환해서 s에 다시 저장.
            
        }
        //탈출했을때
        answer[0] = count;
        answer[1] = removeCount;
        
        return answer;
    }
}
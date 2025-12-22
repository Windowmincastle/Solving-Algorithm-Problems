import java.io.*;
import java.util.*;

class Solution {
    public long solution(long n) {
        
        // 118372의 각 자릿수를 잘라서 오름차순 정렬해야함.
        
        // 1. n을 String으로 변환하자
        String strConvert = String.valueOf(n);
        int len = strConvert.length();
        // 2. int[] 타입으로 바꿔서 담자.
        int[] intConvert = new int[len];
        
        for (int i=0; i<intConvert.length; i++) {
            intConvert[i] = strConvert.charAt(i) - '0';
        }
        //3. 오름차순 정렬하자.
        Arrays.sort(intConvert);
        //4. 문자열로 바꾸자.
        
        strConvert = "";
        for (int j=intConvert.length-1; j >= 0; j--) {
            strConvert += String.valueOf(intConvert[j]);
        }
        long answer = Long.parseLong(strConvert);
        return answer;
    }
}
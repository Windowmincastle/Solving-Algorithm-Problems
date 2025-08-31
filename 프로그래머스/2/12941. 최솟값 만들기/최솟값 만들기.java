import java.io.*;
import java.util.*;


class Solution
{
    static Integer[] boxing (int[] ary){
        
        Integer[] boxingAry = new Integer[ary.length];
        
        for (int i=0; i< ary.length; i++){
            
            boxingAry[i] = ary[i];
        }
        
        return boxingAry;
    }
    
    static int calculate(Integer[] a, Integer[] b){
        
        int ans = 0;
        int len = a.length;
        
        for (int i=0; i<len; i++){
            ans += a[i] * b[i];
        }
        
        return ans;
    }
    
    public int solution(int []A, int []B)
    {
        int answer = 0;
        
        Integer[] convertA = boxing(A);
        Integer[] convertB = boxing(B);
        
        Arrays.sort(convertA);
        Arrays.sort(convertB,Collections.reverseOrder());
        
        answer = calculate(convertA,convertB);
        

        return answer;
    }
}
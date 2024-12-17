import java.io.*;
import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        Arrays.sort(A);
        Arrays.sort(B);
        
        int minValue = 0;
        
        for (int i=0; i< A.length; i++){
            
            minValue += A[i] * B[B.length - 1 - i];
            
        }
        

        return minValue;
    }
}
import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n) {
        // 10을 x로 나눈 나머지가 1이 되도록 하는 가장 작은 자연수 x를 return 하도록
        // n보다 큰 수로 나누는건 의미가 없다.
        // 가장 작은 자연수를 갱신한다.
        int answer = Integer.MAX_VALUE;
        
        for (int i=2; i<=n; i++) {
            
            if ( n % i == 1 ) {
                answer = Math.min(i,answer);
            }
        }
        
        return answer;
    }
}
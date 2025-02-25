import java.util.*;

class Solution {
    public long[] solution(int x, int n) {
        //정수 x와 , 자연수 n , x부터 시작해서 x씩 증가하는 숫자를
        long[] answer = new long[n];
        
        answer = cal(x,n);
        
        return answer;
    
    }
    
    public static long[] cal (int input, int size){
        
        long[] temp = new long[size];
        
        List<Long> list = new ArrayList<>();
        long x = input;
        
        for(int i=0; i<size; i++){
            list.add(x);
            x += input;
        }
        
        for (int j=0; j<size; j++){
            
            temp[j] = list.get(j);
            
        }
        
        return temp;
    }

}
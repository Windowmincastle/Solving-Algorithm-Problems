class Solution {
    
    public static long getStartEndSum(int start, int end){
        
        if( start == end ){
            return start;
        }
        
        int temp = 0;
        
        if (start > end ){
            temp = start;
            start = end;
            end = temp;
        }
        
        
        long sum = 0;
        
        for (int i=start; i<=end; i++){
            sum += i;
        }
        
        return sum;
    }
    
    public long solution(int a, int b) {
        long answer = getStartEndSum(a,b);
        return answer;
    }
}
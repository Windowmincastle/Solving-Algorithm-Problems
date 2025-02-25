class Solution {
    public double solution(int[] arr) {
        
        int len = arr.length;
        double total = 0;
        
        for(int i=0; i<len; i++){
            
            total += arr[i];
            
        }
        
        
        double answer = total / len;
        return answer;
    }
}
class Solution {
    
    static double getAryAvg(int[] ary){
        
        int length = ary.length;
        double sum = 0;
        
        for (int i=0; i<length; i++){
            sum += ary[i];
        }
        
        double answer = sum / length ;
        
        return answer;
    }
    
    public double solution(int[] arr) {
        return getAryAvg(arr);
    }
}